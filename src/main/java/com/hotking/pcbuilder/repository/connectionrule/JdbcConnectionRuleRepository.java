package com.hotking.pcbuilder.repository.connectionrule;

import com.hotking.pcbuilder.entity.ConnectionRule;

import java.util.List;

public interface JdbcConnectionRuleRepository {

    List<ConnectionRule> findAllBySourceTargetCategory(Long sourceId, Long targetId);

    List<ConnectionRule> findAllBySourceCategory(Long sourceId);
}
