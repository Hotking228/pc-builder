package com.hotking.pcbuilder.config;

import com.hotking.pcbuilder.controller.SortOrder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "pages")
@Configuration
@Component
@Data
@NoArgsConstructor
public class Pages {

    private Integer pageSize;
    private Integer defaultPage;
    private SortOrder defaultSortOrder;
}
