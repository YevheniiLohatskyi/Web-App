package com.homework.webapp.mapper;

import com.homework.webapp.dto.Manufacturer;
import com.homework.webapp.model.ManufacturerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ManufacturerMapper {
    public Manufacturer mapManufacturerEntityToManufacturer(ManufacturerEntity entity){
        return new Manufacturer()
                .setId(entity.getId())
                .setName(entity.getName())
                .setProducts(entity.getProducts());
    }

    public List<Manufacturer> mapManufacturerEntitiesToManufacturers(List<ManufacturerEntity> entities){
        return entities.stream()
                .map(this::mapManufacturerEntityToManufacturer)
                .collect(Collectors.toList());
    }

    public ManufacturerEntity mapManufacturerToManufacturerEntity(Manufacturer manufacturer){
        return new ManufacturerEntity()
                .setId(manufacturer.getId())
                .setName(manufacturer.getName())
                .setProducts(manufacturer.getProducts());
    }
}
