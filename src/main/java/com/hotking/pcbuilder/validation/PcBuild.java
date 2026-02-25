package com.hotking.pcbuilder.validation;

import com.hotking.pcbuilder.entity.Product;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.*;

@Build
@Component
public class PcBuild {


    private Set<Product> build = new LinkedHashSet<>();

    public PcBuild addComponent(Product product){
        System.out.println("=============ADD COMPONENT============");
        build.add(product);
        return this;
    }

    public void removeComponent(Long id){
        for (Product product : build) {
            if(product.getId() == id){
                build.remove(product);
            }
        }
    }

    public void removeLastComponent(){
        Product p = null;
        for (Product product : build) {
            p = product;
        }

        build.remove(p);
    }

    public LinkedList<Product> get(){


        return new LinkedList<>(build);
    }
}
