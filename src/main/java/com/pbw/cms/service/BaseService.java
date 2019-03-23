package com.pbw.cms.service;


import java.util.List;

public interface BaseService<T,ID> {

    List<T> findAll();

    T save(T obj);

    T findById(ID id);

    void deleteById(ID id);

    void update(T obj);
}
