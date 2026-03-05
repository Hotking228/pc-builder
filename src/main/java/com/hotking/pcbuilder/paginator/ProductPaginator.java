package com.hotking.pcbuilder.paginator;

import com.hotking.pcbuilder.controller.SortOrder;
import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.parsers.VersionParser;
import com.hotking.pcbuilder.pcbuild.PcBuild;
import com.hotking.pcbuilder.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Aspect
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductPaginator implements Paginator{

    private final ProductRepository productRepository;
    private final ProductPage productPage;
    private final PcBuild pcBuild;
    private final VersionParser versionParser;
    @Getter
    private Integer size = 0;

    @Override
    @AfterReturning(value = "execution(* com.hotking.pcbuilder.repository.ProductRepository.findAllBySlug(..))", returning = "result")
    public void paginate(Object result) {
        List<Product> origin = (List<Product>) result;
        List<Product> list = origin;

        list = filter(list);
        list = sort(list);

        size = list.size();

        list = list.stream()
                .skip((long) productPage.getPageSize() * productPage.getPageNum())
                .limit(productPage.getPageSize())
                .toList();

        origin.clear();
        origin.addAll(list);


    }

    private List<Product> filter(List<Product> list){
        return list.stream()
                .filter(pcBuild::validateComponent)
                .filter(p -> p.getPrice() >= productPage.getMinPrice())
                .filter(p -> p.getPrice() <= productPage.getMaxPrice())
                .filter(p -> {
                    if(productPage.getManufacturer() == null || productPage.getManufacturer().isEmpty()){
                        return true;
                    } else {
                        return productPage.getManufacturer().contains(p.getManufacturer());
                    }
                })
                .toList();
    }

    private List<Product> sort(List<Product> origin){
        Map<String, SortOrder> orders = productPage.getSortOrders();
        List<Product> list = new ArrayList<>();
        list.addAll(origin);
        for (var order : orders.entrySet()){
            if(order.getValue().equals(SortOrder.ASC)){
                list.sort(Comparator.comparing(p -> {
                    if(order.getKey().equals("price")){
                        return p.getPrice().longValue();
                    } else if(order.getKey().equals("name")){
                        return 0L;
                    }

                    long val = 0L;
                    try {
                        val = Long.parseLong(p.getSpecifications().get(order.getKey()).getSpecValue());
                    } catch (NumberFormatException e){
                        val = Long.parseLong(versionParser.parse(p.getSpecifications().get(order.getKey()).getSpecValue()));
                    }

                    return val;
                }));
            } else if(order.getValue().equals(SortOrder.DESC)){
                list.sort(Comparator.comparing(p -> {
                    if(order.getKey().equals("price")){
                        return -p.getPrice().longValue();
                    } else if(order.getKey().equals("name")){
                        return 0L;
                    }

                    long val = 0L;
                    try {
                        val = -Long.parseLong(p.getSpecifications().get(order.getKey()).getSpecValue());
                    } catch (NumberFormatException e){
                        val = -Long.parseLong(versionParser.parse(p.getSpecifications().get(order.getKey()).getSpecValue()));
                    }

                    return val;
                }));
            }
        }

        return list;
    }
}
