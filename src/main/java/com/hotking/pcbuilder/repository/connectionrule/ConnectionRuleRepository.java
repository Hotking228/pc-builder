package com.hotking.pcbuilder.repository.connectionrule;

import com.hotking.pcbuilder.entity.ConnectionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConnectionRuleRepository extends JpaRepository<ConnectionRule, Long>, JdbcConnectionRuleRepository {

    @Query("select c_r from ConnectionRule c_r where c_r.sourceCategory.id = :id")
    public Optional<ConnectionRule> findBySourceCategoryId(Long id);
}
