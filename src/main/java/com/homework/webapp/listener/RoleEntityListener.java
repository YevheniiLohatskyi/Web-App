package com.homework.webapp.listener;

import com.homework.webapp.model.RoleEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class RoleEntityListener {
    @PrePersist
    public void setRandomUuid(RoleEntity entity) {
        entity.setUuid(UUID.randomUUID());
    }
}
