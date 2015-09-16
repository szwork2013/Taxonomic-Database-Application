package com.unep.wcmc.repository;

import com.unep.wcmc.model.Comment;
import com.unep.wcmc.model.Species;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

     Page<Comment> findAllBySpecie(Species specie, Pageable pageable);
}
