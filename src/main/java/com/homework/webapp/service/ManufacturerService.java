package com.homework.webapp.service;

import com.homework.webapp.exception.NotFoundEntityException;
import com.homework.webapp.model.ManufacturerEntity;
import com.homework.webapp.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ManufacturerService implements BaseService<ManufacturerEntity> {
    private final ManufacturerRepository repository;

    @Override
    public void createOne(ManufacturerEntity entity) {
        repository.save(entity);
    }

    @Override
    public void updateOne(ManufacturerEntity entity) {
        repository.save(entity);
    }

    @Override
    public void deleteOneById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public ManufacturerEntity findOneById(UUID id) throws NotFoundEntityException {
        return repository.findById(id).orElseThrow(() -> new NotFoundEntityException(id));
    }

    @Override
    public List<ManufacturerEntity> findAll() {
        return repository.findAll();
    }
}
