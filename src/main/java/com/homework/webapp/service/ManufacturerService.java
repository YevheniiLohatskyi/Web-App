package com.homework.webapp.service;

import com.homework.webapp.dto.Manufacturer;
import com.homework.webapp.exception.NotFoundEntityException;
import com.homework.webapp.mapper.ManufacturerMapper;
import com.homework.webapp.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ManufacturerService implements BaseService<Manufacturer> {
    private final ManufacturerRepository repository;
    private final ManufacturerMapper mapper;

    @Override
    public void createOne(Manufacturer manufacturer) {
        repository.save(mapper.mapManufacturerToManufacturerEntity(manufacturer));
    }

    @Override
    public void updateOne(Manufacturer manufacturer) {
        repository.save(mapper.mapManufacturerToManufacturerEntity(manufacturer));
    }

    @Override
    public void deleteOneById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Manufacturer findOneById(Long id) throws NotFoundEntityException {
        return mapper.mapManufacturerEntityToManufacturer(repository.findById(id).orElseThrow(NotFoundEntityException::new));
    }

    @Override
    public List<Manufacturer> findAll() {
        return mapper.mapManufacturerEntitiesToManufacturers(repository.findAll());
    }
}
