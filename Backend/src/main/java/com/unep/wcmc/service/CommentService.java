package com.unep.wcmc.service;

import com.unep.wcmc.model.Comment;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends AbstractService<Comment, CommentRepository> {

    public Page<Comment> findAllBySpecie(Species specie, Pageable pageable){
        return repo.findAllBySpecie(specie, pageable);
    }
}
