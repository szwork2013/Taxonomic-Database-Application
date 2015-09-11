package com.unep.wcmc.repository;

import com.unep.wcmc.model.Image;
import com.unep.wcmc.model.Species;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Page<Image> findAllBySpecie(Species specie, Pageable pageable);
}
