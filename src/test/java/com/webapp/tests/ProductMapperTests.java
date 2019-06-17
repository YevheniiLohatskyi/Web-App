package com.webapp.tests;

import com.homework.webapp.dto.Product;
import com.homework.webapp.mapper.ProductMapper;
import com.homework.webapp.model.ManufacturerEntity;
import com.homework.webapp.model.ProductEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ProductMapperTests {
    private ProductMapper mapper;

    @Before
    public void beforeTest() {
        mapper = new ProductMapper();
    }

    @Test
    public void mapProducerToProducerEntity() {
        Product product = new Product()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setName("Car1")
                .setPrice(BigDecimal.valueOf(1000))
                .setManufacturer(new ManufacturerEntity());

        ProductEntity productEntity = mapper.mapProductToProductEntity(product);
        assertEquals(product.getId(), productEntity.getId());
        assertEquals(product.getUuid(), productEntity.getUuid());
        assertEquals(product.getName(), productEntity.getName());
        assertEquals(product.getPrice(), productEntity.getPrice());
        assertEquals(product.getManufacturer(), productEntity.getManufacturer());
    }

    @Test
    public void mapProducerEntityToProducer() {
        ProductEntity productEntity = new ProductEntity()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setName("Car1")
                .setPrice(BigDecimal.valueOf(1000))
                .setManufacturer(new ManufacturerEntity());

        Product product = mapper.mapProductEntityToProduct(productEntity);

        assertEquals(product.getId(), productEntity.getId());
        assertEquals(product.getUuid(), productEntity.getUuid());
        assertEquals(product.getName(), productEntity.getName());
        assertEquals(product.getPrice(), productEntity.getPrice());
        assertEquals(product.getManufacturer(), productEntity.getManufacturer());
    }

    @Test
    public void mapProducerEntityListToProducerList() {
        List<ProductEntity> productEntities = new ArrayList<>();

        productEntities.add(new ProductEntity()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setName("Car1")
                .setPrice(BigDecimal.valueOf(1000))
                .setManufacturer(new ManufacturerEntity()));

        productEntities.add(new ProductEntity()
                .setId(2L)
                .setUuid(UUID.randomUUID())
                .setName("Car2")
                .setPrice(BigDecimal.valueOf(1520))
                .setManufacturer(new ManufacturerEntity()));

        List<Product> products = mapper.mapProductEntitiesToProducts(productEntities);

        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).getId(), productEntities.get(i).getId());
            assertEquals(products.get(i).getUuid(), productEntities.get(i).getUuid());
            assertEquals(products.get(i).getName(), productEntities.get(i).getName());
            assertEquals(products.get(i).getPrice(), productEntities.get(i).getPrice());
            assertEquals(products.get(i).getManufacturer(), productEntities.get(i).getManufacturer());
        }
    }
}
