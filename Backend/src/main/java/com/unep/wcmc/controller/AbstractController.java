package com.unep.wcmc.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unep.wcmc.service.BaseService;

/**
 * Abstract controller that encapsulates all boilerplate code needed to
 * create a simple controller object
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 * @param <E> entity object that extends from {@link Serializable}
 * @param <S> service that implements basic operations from {@link BaseService}
 */
public abstract class AbstractController<E extends Serializable, 
										 S extends BaseService<E>> {
	@Autowired
	protected S service;
	
	@RequestMapping(method= RequestMethod.GET)
    public List<E> index() {
        return (List<E>)service.list();
    }

    @RequestMapping(method= RequestMethod.POST)
    public E add(@RequestBody E e){
        return service.save(e);
    }

    @RequestMapping(method= RequestMethod.PUT, value="{id}")
    public E edit(@RequestBody E e, @PathVariable String id){
        E obj = service.get(Long.valueOf(id));
        return service.save(obj);
    }

    @RequestMapping(method= RequestMethod.GET, value="{id}")
    public E view(@PathVariable String id) {
        return service.get(Long.valueOf(id));
    }

    @RequestMapping(method= RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id) {
    	service.delete(Long.valueOf(id));
    }
}
