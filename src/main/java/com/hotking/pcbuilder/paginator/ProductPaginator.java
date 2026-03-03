package com.hotking.pcbuilder.paginator;

import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.pcbuild.PcBuild;
import com.hotking.pcbuilder.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Aspect
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductPaginator implements Paginator{

    private final ProductRepository productRepository;
    private final ProductPage productPage;
    private final PcBuild pcBuild;
    @Getter
    private Integer size = 0;

    @Override
    @AfterReturning(value = "execution(* com.hotking.pcbuilder.repository.ProductRepository.findAllBySlug(..))", returning = "result")
    public void paginate(Object result) {
        List<Product> origin = (List<Product>) result;
        List<Product> list = origin;


        list = list.stream()
                .filter(pcBuild::validateComponent)
                .filter(p -> p.getPrice() >= productPage.getMinPrice())
                .filter(p -> p.getPrice() <= productPage.getMaxPrice())
                .filter(p -> {
                    if(productPage.getManufacturer() == null || productPage.getManufacturer().isEmpty() || productPage.getManufacturer().isBlank()){
                        return true;
                    } else {
                        return p.getManufacturer().equals(productPage.getManufacturer());
                    }
                })
                .toList();
        size = list.size();
        list = list.stream()
                .skip((long) productPage.getPageSize() * productPage.getPageNum())
                .limit(productPage.getPageSize())
                .toList();
        origin.clear();
        origin.addAll(list);
    }
}
