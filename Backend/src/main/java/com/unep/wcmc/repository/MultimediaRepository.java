package com.unep.wcmc.repository;

import com.unep.wcmc.model.Multimedia;
import com.unep.wcmc.model.Species;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {

    Page<Multimedia> findAllBySpecie(Species specie, Pageable pageable);
}
