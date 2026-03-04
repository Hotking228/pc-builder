package com.hotking.pcbuilder.paginator;

import com.hotking.pcbuilder.controller.SortOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductPage {
//TODO: в зависимости от категории можно добавить свои фильтры
    private Map<String, SortOrder> sortOrders = new HashMap<>();
    private Float minPrice;
    private Float maxPrice;
    private Set<String> manufacturer = new HashSet<>();
    private Integer pageSize;
    private Integer pageNum;

    public void set(ProductPage page) {
        if(page.getSortOrders() != null){
            sortOrders = Map.copyOf(page.getSortOrders());
        }
        minPrice = page.getMinPrice();
        maxPrice = page.getMaxPrice();
        if(page.getManufacturer() != null){
            page.getManufacturer().stream()
                    .filter(man -> !man.isBlank())
                    .forEach(manufacturer::add);
        }
        pageSize = page.getPageSize();
        pageNum = page.getPageNum();
    }

    public boolean isEmpty() {
        return maxPrice == null || pageSize == null || pageNum == null;
    }
}
