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
	
	/*
	 * (non-Javadoc)
	 * @see com.unep.wcmc.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public E save(E entity) {
		return repo.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.unep.wcmc.service.BaseService#list()
	 */
	@Override
	public List<E> list() {
		return Lists.newArrayList(repo.findAll());
	}

	/*
	 * (non-Javadoc)
	 * @see com.unep.wcmc.service.BaseService#delete(java.lang.Long)
	 */
	@Override
	public Boolean delete(Long id) {
		repo.delete(id);
		return Boolean.TRUE;
	}

	/*
	 * (non-Javadoc)
	 * @see com.unep.wcmc.service.BaseService#get(java.lang.Long)
	 */
	@Override
	public E get(Long id) {
		return repo.findOne(id);
	}
}
