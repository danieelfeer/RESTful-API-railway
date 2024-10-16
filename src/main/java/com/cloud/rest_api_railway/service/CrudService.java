package com.cloud.rest_api_railway.service;

import java.util.List;

public interface CrudService <ID, T> {
    List<T> findAll();
    T findById(ID id);
    T create(T entity);
    T update(ID id, T entity);
    void delete(ID id);
}
