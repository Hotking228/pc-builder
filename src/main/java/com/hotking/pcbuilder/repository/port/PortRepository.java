package com.hotking.pcbuilder.repository.port;

import com.hotking.pcbuilder.entity.Port;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortRepository extends JpaRepository<Port, Long>, JdbcPortRepository {
}
