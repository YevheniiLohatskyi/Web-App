package com.homework.webapp.listener;

import com.homework.webapp.model.ProductEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class ProductEntityListener {
    @PrePersist
    public void setRandomUuid(ProductEntity entity) {
        entity.setUuid(UUID.randomUUID());
    }
}
