package com.hotking.pcbuilder.repository.port;

import com.hotking.pcbuilder.entity.Port;
import com.hotking.pcbuilder.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RequiredArgsConstructor
public class JdbcPortRepositoryImpl implements JdbcPortRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProductRepository productRepository;

    private static final String FIND_ALL_BY_PRODUCT_ID_SQL = """
            SELECT 
                id,
                product_id,
                port_name,
                portnum
            FROM port
            WHERE product_id = ?
            """;

    @Override
    public List<Port> findAllByProductId(Long productId) {
        //TODO исключение
        return jdbcTemplate.query(FIND_ALL_BY_PRODUCT_ID_SQL, (rs, rowNum) -> {
            return Port.builder()
                    .id(rs.getLong("id"))
                    .product(productRepository.findById(rs.getLong("product_id")).orElseThrow())
                    .portName(rs.getString("port_name"))
                    .portNum(rs.getInt("portnum"))
                    .build();
        },
                productId);
    }
}
