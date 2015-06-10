package com.unep.wcmc.service;


public interface BaseService<T> {

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity
     * @return the saved entity
     */
    public T save(T entity);

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    Iterable<T> list();

    /**
     * Deletes a given entity.
     *
     * @param id
     */
    Boolean delete(Long id);

    /**
     * View a given entity.
     *
     * @param id
     */
    public T get(Long id);
}
