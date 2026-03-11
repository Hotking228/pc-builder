package com.hotking.pcbuilder.repository.port;

import com.hotking.pcbuilder.entity.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PortRepository extends JpaRepository<Port, Long>, JdbcPortRepository {

    @Query(value = "SELECT " +
            "    p.port_name " +
            "FROM port p " +
            "JOIN product pr ON pr.id = p.product_id " +
            "JOIN product_category p_c ON p_c.id = pr.category_id " +
            "WHERE p_c.slug = 'cpus' " +
            "GROUP BY p.port_name;",
    nativeQuery = true)
    List<Port> findAllBySlug(String slug);
}
