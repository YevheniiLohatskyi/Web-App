package com.webapp.tests;

import com.homework.webapp.dto.User;
import com.homework.webapp.mapper.UserMapper;
import com.homework.webapp.model.RoleEntity;
import com.homework.webapp.model.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UserMapperTests {
    private UserMapper mapper;

    @Before
    public void beforeTest() {
        mapper = new UserMapper();
    }

    @Test
    public void mapProducerToProducerEntity() {
        User user = new User()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("email_example@gmail.com")
                .setPassword("root")
                .setRole(new RoleEntity());

        UserEntity userEntity = mapper.mapUserToUserEntity(user);

        assertEquals(user.getId(), userEntity.getId());
        assertEquals(user.getUuid(), userEntity.getUuid());
        assertEquals(user.getFirstName(), userEntity.getFirstName());
        assertEquals(user.getLastName(), userEntity.getLastName());
        assertEquals(user.getEmail(), userEntity.getEmail());
        assertEquals(user.getPassword(), userEntity.getPassword());
        assertEquals(user.getRole(), userEntity.getRole());
    }

    @Test
    public void mapProducerEntityToProducer() {
        UserEntity userEntity = new UserEntity()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("email_example@gmail.com")
                .setPassword("root")
                .setRole(new RoleEntity());

        User user = mapper.mapUserEntityToUser(userEntity);

        assertEquals(user.getId(), userEntity.getId());
        assertEquals(user.getUuid(), userEntity.getUuid());
        assertEquals(user.getFirstName(), userEntity.getFirstName());
        assertEquals(user.getLastName(), userEntity.getLastName());
        assertEquals(user.getEmail(), userEntity.getEmail());
        assertEquals(user.getPassword(), userEntity.getPassword());
        assertEquals(user.getRole(), userEntity.getRole());
    }

    @Test
    public void mapProducerEntityListToProducerList() {
        List<UserEntity> userEntities = new ArrayList<>();

        userEntities.add(new UserEntity()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("email_example@gmail.com")
                .setPassword("root")
                .setRole(new RoleEntity()));

        userEntities.add(new UserEntity()
                .setId(2L)
                .setUuid(UUID.randomUUID())
                .setFirstName("Stepan")
                .setLastName("Stepanov")
                .setEmail("email_example_other@gmail.com")
                .setPassword("roots")
                .setRole(new RoleEntity()));

        List<User> users = mapper.mapUserEntitiesToUsers(userEntities);

        for (int i = 0; i < users.size(); i++) {
            assertEquals(users.get(i).getId(), userEntities.get(i).getId());
            assertEquals(users.get(i).getUuid(), userEntities.get(i).getUuid());
            assertEquals(users.get(i).getFirstName(), userEntities.get(i).getFirstName());
            assertEquals(users.get(i).getLastName(), userEntities.get(i).getLastName());
            assertEquals(users.get(i).getEmail(), userEntities.get(i).getEmail());
            assertEquals(users.get(i).getPassword(), userEntities.get(i).getPassword());
            assertEquals(users.get(i).getRole(), userEntities.get(i).getRole());
        }
    }
}
