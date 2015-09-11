package com.unep.wcmc.service;

import com.unep.wcmc.model.Image;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.ImageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImageService extends AbstractService<Image, ImageRepository> {

    public Page<Image> findAllBySpecie(Species specie, Pageable pageable) {
        return repo.findAllBySpecie(specie, pageable);
    }
}
