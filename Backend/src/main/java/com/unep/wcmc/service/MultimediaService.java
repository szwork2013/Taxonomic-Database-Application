package com.unep.wcmc.service;

import com.unep.wcmc.model.Multimedia;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.MultimediaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MultimediaService extends AbstractService<Multimedia, MultimediaRepository> {

    public Page<Multimedia> findAllBySpecie(Species specie, Pageable pageable) {
        return repo.findAllBySpecie(specie, pageable);
    }
}
