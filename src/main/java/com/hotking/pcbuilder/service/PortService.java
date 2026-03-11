package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.entity.Port;
import com.hotking.pcbuilder.repository.port.PortRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PortService {

    private final PortRepository portRepository;

    public List<Port> findAllByProductId(Long productId){
        return portRepository.findAllByProductId(productId);
    }

    public List<Port> findAllBySlug(String slug) {
        return portRepository.findAllBySlug(slug);
    }
}
