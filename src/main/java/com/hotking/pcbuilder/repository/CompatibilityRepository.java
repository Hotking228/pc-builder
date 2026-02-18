package com.hotking.pcbuilder.repository;

import com.hotking.pcbuilder.entity.CompatibilityRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompatibilityRepository extends JpaRepository<CompatibilityRule, Long> {
}
