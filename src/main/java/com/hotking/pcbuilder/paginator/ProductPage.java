package com.hotking.pcbuilder.paginator;

import com.hotking.pcbuilder.controller.SortOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductPage {
//TODO: в зависимости от категории можно добавить свои фильтры
    private List<SortOrder> sortOrders = new ArrayList<>();
    private List<String> sortFields = new ArrayList<>();
    private Float minPrice;
    private Float maxPrice;
    private String manufacturer;
    private Integer pageSize;
    private Integer pageNum;

    public void set(ProductPage page) {
        sortOrders = page.getSortOrders();
        sortFields = page.getSortFields();
        minPrice = page.getMinPrice();
        maxPrice = page.getMaxPrice();
        manufacturer = page.getManufacturer();
        pageSize = page.getPageSize();
        pageNum = page.getPageNum();
    }
}
