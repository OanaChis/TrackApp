package com.TrackApp.TrackApp.services;

import java.util.List;

/**
 * Created by oana_ on 6/14/2017.
 */
public interface CrudService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
