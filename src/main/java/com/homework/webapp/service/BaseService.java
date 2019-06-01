package com.homework.webapp.service;

import com.homework.webapp.exception.NotFoundEntityException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BaseService<T> {
    void createOne(T entity);

    void updateOne(T entity);

    void deleteOneById(UUID id);

    T findOneById(UUID id) throws NotFoundEntityException;

    List<T> findAll();
}
