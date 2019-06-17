package com.homework.webapp.listener;

import com.homework.webapp.model.UserEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class UserEntityListener {
    @PrePersist
    public void setRandomUuid(UserEntity entity) {
        entity.setUuid(UUID.randomUUID());
    }
}
