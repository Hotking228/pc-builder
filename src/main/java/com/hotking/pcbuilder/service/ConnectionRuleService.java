package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.entity.ConnectionRule;
import com.hotking.pcbuilder.repository.connectionrule.ConnectionRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ConnectionRuleService {

    private final ConnectionRuleRepository connectionRuleRepository;

    public List<ConnectionRule> findAllBySourceTargetCategory(Long sourceId, Long targetId){
        return connectionRuleRepository.findAllBySourceTargetCategory(sourceId, targetId);
    }

    public List<ConnectionRule> findBySourceCategory(Long sourceId){
        return connectionRuleRepository.findAllBySourceCategory(sourceId);
    }
}
