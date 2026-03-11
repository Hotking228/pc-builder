package com.hotking.pcbuilder.repository.port;

import com.hotking.pcbuilder.entity.PossiblePort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PossiblePortRepository extends JpaRepository<PossiblePort, Long> {

    @Query("select p_p from PossiblePort p_p join p_p.category c where c.slug = :slug")
    List<PossiblePort> findAllBySlug(String slug);
}
