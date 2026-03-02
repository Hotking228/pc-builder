package com.hotking.pcbuilder.repository.port;

import com.hotking.pcbuilder.entity.Port;

import java.util.List;

public interface JdbcPortRepository {

    List<Port> findAllByProductId(Long productId);
}
