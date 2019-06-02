package com.homework.webapp.mapper;

import com.homework.webapp.dto.User;
import com.homework.webapp.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserMapper {
    public User mapUserEntityToUser(UserEntity entity) {
        return new User()
                .setId(entity.getId())
                .setEmail(entity.getEmail())
                .setPassword(entity.getPassword())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setRole(entity.getRole());
    }

    public List<User> mapUserEntitiesToUsers(List<UserEntity> entities) {
        return entities.stream()
                .map(this::mapUserEntityToUser)
                .collect(toList());
    }

    public UserEntity mapUserToUserEntity(User user) {
        UserEntity entity = new UserEntity()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setRole(user.getRole());
        entity.setId(user.getId());
        return entity;
    }
}
