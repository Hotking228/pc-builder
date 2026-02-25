package com.hotking.pcbuilder.validation;

import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.entity.Specification;
import com.hotking.pcbuilder.service.ProductService;
import com.hotking.pcbuilder.service.SpecificationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Build
@Component
@RequiredArgsConstructor
public class PcBuild {

    private Map<Long, Integer> build = new LinkedHashMap<>();
    private final BuildCompletenessValidator validator;
    private final ProductService productService;

    public boolean validateComponent(Product product){
        build.putIfAbsent(product.getId(), 0);
        build.put(product.getId(), build.get(product.getId()) + 1);
        boolean valid = validator.isValid(this, product);
        removeLastComponent();
        return valid;
    }


    public PcBuild addComponent(Product product){
        build.putIfAbsent(product.getId(), 0);
        build.put(product.getId(), build.get(product.getId()) + 1);

        return this;
    }

    public void removeComponent(Long id){
        build.put(id, build.get(id) - 1);
    }

    public void removeLastComponent(){
        Map.Entry<Long, Integer> p = null;
        for (var product : build.entrySet()) {
            p = product;
        }

        build.put(p.getKey(), p.getValue() - 1);
    }

    public LinkedList<Product> get(){

        LinkedList<Product> products = new LinkedList<>();
        for (var entry : build.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                products.add(productService.findByIdEntity(entry.getKey()));
            }
        }

        return products;
    }
}
