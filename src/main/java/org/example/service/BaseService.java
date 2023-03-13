package org.example.service;

/*
    T - requestDto
    R - responseDto
    E - model
 */

import java.util.List;
import java.util.UUID;

public interface BaseService<T,R,E>{
    boolean create (T t);
    R get (UUID id);
    List<R> getList ();
    boolean delete(UUID id);
    boolean update (UUID id, T t);
    List<E> getData();
    boolean writeData(List<E> data);
    E getEntity (UUID id);
}
