package com.unep.wcmc.service;

import com.unep.wcmc.model.Multimedia;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.MultimediaRepository;
import com.unep.wcmc.repository.SpeciesRepository;
import com.unep.wcmc.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class MultimediaService extends AbstractService<Multimedia, MultimediaRepository> {

    @Autowired
    private SpeciesRepository speciesRepo;

    public Page<Multimedia> findAllBySpecie(Species specie, Pageable pageable) {
        return repo.findAllBySpecie(specie, pageable);
    }

    public Page<Multimedia> findAllBySpecieAndTitle(Species specie, String title, Pageable pageable) {
        return repo.findAllBySpecieAndTitleStartingWith(specie, title, pageable);
    }

    /**
     * Persists the multimedia file data
     *
     * @param file
     * @param mimeType
     * @param title
     * @param legend
     * @param coverPhoto
     * @param description
     * @param species
     * @return
     */
    public Multimedia save(MultipartFile file, String mimeType, String title, String legend,
                           Boolean coverPhoto, String description, Species species) {

        Multimedia result = null;

        if (!file.isEmpty()) {

            try {
                Multimedia media = new Multimedia(file);
                media.setTitle(title);
                media.setLegend(legend);
                media.setDescription(description);

                media.setAuthor(SecurityUtils.getUser());
                media.setSpecie(species);
                media.setDate(new Date());
                result = repo.save(media);

                if (coverPhoto && mimeType.startsWith("image/")) {
                    // delete the cover photo if exists
                    if (species.getCoverPhoto() != null) {
                        repo.delete(species.getCoverPhoto().getId());
                    }

                    //to fix the bug The fix for HHH-6848 causes IllegalStateException
                    // when merging an entity results in merging more than one representation of the same detached entity.
                    //https://hibernate.atlassian.net/browse/HHH-9106
                    Multimedia mediaPhoto = new Multimedia(file);
                    mediaPhoto.setTitle(title);
                    mediaPhoto.setAuthor(SecurityUtils.getUser());
                    mediaPhoto.setLegend(legend);
                    mediaPhoto.setDescription(description);
                    mediaPhoto.setDate(new Date());
                    species.setCoverPhoto(repo.save(mediaPhoto));
                    speciesRepo.save(species);
                }

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }


        return result;
    }
}
