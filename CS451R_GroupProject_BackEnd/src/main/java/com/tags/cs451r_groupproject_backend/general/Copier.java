package com.tags.cs451r_groupproject_backend.general;

/**
 * An interface to copy an item from a given entity, without returning the result.
 * The type parameter T is the class of the entity that is to be copied.
 * This class should primarily be used to copy from the same class or to copy from entity
 * to DTOs.
 */
@FunctionalInterface
public interface Copier<T> {

    /**
     * Copies the entity without returning the result. Relies on only side effects.
     * @param entity The entity to be copied.
     */
    void copyFrom(T entity);
}
