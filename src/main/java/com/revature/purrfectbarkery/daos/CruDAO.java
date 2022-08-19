package com.revature.purrfectbarkery.daos;

import java.util.List;

public interface CruDAO<T> {
    void save(T obj);
    void update(T obj);
    void delete(String id);
    T getById(String id);
    List<T> getAll();
}
