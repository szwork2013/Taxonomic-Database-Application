package com.unep.wcmc.service;

import com.google.common.collect.Lists;
import com.unep.wcmc.model.BaseEntity;
import com.unep.wcmc.model.Species;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Abstract service that encapsulates all boilerplate code needed to
 * create a simple service object
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 * @param <E> entity object that extends from {@link BaseEntity}
 * @param <R> repository that implements basic operations from {@link CrudRepository}
 */
public abstract class AbstractService<E extends BaseEntity, R extends CrudRepository<E, Long>> implements BaseService<E> {
	
	@Autowired
	protected R repo;

	protected static Logger log = LoggerFactory.getLogger(AbstractService.class);
	
	@Override
	public E save(E entity) {
		return repo.save(entity);
	}

	@Override
	public List<E> list() {
		return Lists.newArrayList(repo.findAll());
	}

	@Override
	public Boolean delete(Long id) {
		repo.delete(id);
		return Boolean.TRUE;
	}

	@Override
	public E get(Long id) {
		return repo.findOne(id);
	}
}
