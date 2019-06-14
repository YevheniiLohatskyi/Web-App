package com.webapp.tests;

import com.homework.webapp.dto.Manufacturer;
import com.homework.webapp.mapper.ManufacturerMapper;
import com.homework.webapp.model.ManufacturerEntity;
import com.homework.webapp.model.ProductEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ManufacturerMapperTests {
    private ManufacturerMapper mapper;

    @Before
    public void beforeTest() {
        mapper = new ManufacturerMapper();
    }

    @Test
    public void mapProducerToProducerEntity() {
        Manufacturer manufacturer = new Manufacturer()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setName("Google")
                .setProducts(new ArrayList<ProductEntity>());

        ManufacturerEntity manufacturerEntity = mapper.mapManufacturerToManufacturerEntity(manufacturer);
        assertEquals(manufacturer.getId(), manufacturerEntity.getId());
        assertEquals(manufacturer.getUuid(), manufacturerEntity.getUuid());
        assertEquals(manufacturer.getProducts(), manufacturerEntity.getProducts());
        assertEquals(manufacturer.getName(), manufacturerEntity.getName());
    }

    @Test
    public void mapProducerEntityToProducer() {
        ManufacturerEntity manufacturerEntity = new ManufacturerEntity()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setName("Google")
                .setProducts(new ArrayList<ProductEntity>());

        Manufacturer manufacturer = mapper.mapManufacturerEntityToManufacturer(manufacturerEntity);

        assertEquals(manufacturer.getId(), manufacturerEntity.getId());
        assertEquals(manufacturer.getUuid(), manufacturerEntity.getUuid());
        assertEquals(manufacturer.getProducts(), manufacturerEntity.getProducts());
        assertEquals(manufacturer.getName(), manufacturerEntity.getName());
    }

    @Test
    public void mapProducerEntityListToProducerList() {
        List<ManufacturerEntity> manufacturerEntities = new ArrayList<>();

        manufacturerEntities.add(new ManufacturerEntity()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setName("Google")
                .setProducts(new ArrayList<ProductEntity>()));

        manufacturerEntities.add(new ManufacturerEntity()
                .setId(2L)
                .setUuid(UUID.randomUUID())
                .setName("Apple")
                .setProducts(new ArrayList<ProductEntity>()));

        List<Manufacturer> manufacturers = mapper.mapManufacturerEntitiesToManufacturers(manufacturerEntities);

        for (int i = 0; i < manufacturers.size(); i++) {
            assertEquals(manufacturers.get(i).getId(), manufacturerEntities.get(i).getId());
            assertEquals(manufacturers.get(i).getUuid(), manufacturerEntities.get(i).getUuid());
            assertEquals(manufacturers.get(i).getProducts(), manufacturerEntities.get(i).getProducts());
            assertEquals(manufacturers.get(i).getName(), manufacturerEntities.get(i).getName());
        }
    }
}
