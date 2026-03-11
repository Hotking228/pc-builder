package com.hotking.pcbuilder.service;

import com.hotking.pcbuilder.entity.PossiblePort;
import com.hotking.pcbuilder.repository.port.PossiblePortRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PossiblePortService {

    private final PossiblePortRepository portRepository;


    public List<PossiblePort> findAllBySlug(String slug) {
        return portRepository.findAllBySlug(slug);
    }
}
