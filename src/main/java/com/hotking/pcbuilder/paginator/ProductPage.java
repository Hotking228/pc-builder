package com.hotking.pcbuilder.paginator;

import com.hotking.pcbuilder.controller.SortOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductPage {
//TODO: в зависимости от категории можно добавить свои фильтры
    private List<SortOrder> sortOrders;
    private List<String> sortFields;
    private Float minPrice;
    private Float maxPrice;
    private String manufacturer;
    private Integer pageSize;
    private Integer pageNum;
}
