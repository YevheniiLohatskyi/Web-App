package com.homework.webapp.listener;

import com.homework.webapp.model.ManufacturerEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class ManufacturerEntityListener {
    @PrePersist
    public void setRandomUuid(ManufacturerEntity entity) {
        entity.setUuid(UUID.randomUUID());
    }
}
