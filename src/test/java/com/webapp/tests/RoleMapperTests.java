package com.webapp.tests;

import com.homework.webapp.dto.Role;
import com.homework.webapp.mapper.RoleMapper;
import com.homework.webapp.model.RoleEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class RoleMapperTests {
    private RoleMapper mapper;

    @Before
    public void beforeTest() {
        mapper = new RoleMapper();
    }

    @Test
    public void mapProducerToProducerEntity() {
        Role role = new Role().setName("User");

        RoleEntity roleEntity = mapper.mapRoleToRoleEntity(role);
        assertEquals(role.getId(), roleEntity.getId());
        assertEquals(role.getUuid(), roleEntity.getUuid());
        assertEquals(role.getName(), roleEntity.getName());
    }

    @Test
    public void mapProducerEntityToProducer() {
        RoleEntity roleEntity = new RoleEntity()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setName("User");

        Role role = mapper.mapRoleEntityToRole(roleEntity);

        assertEquals(role.getId(), roleEntity.getId());
        assertEquals(role.getUuid(), roleEntity.getUuid());
        assertEquals(role.getName(), roleEntity.getName());
    }

    @Test
    public void mapProducerEntityListToProducerList() {
        List<RoleEntity> roleEntities = new ArrayList<>();

        roleEntities.add(new RoleEntity()
                .setId(1L)
                .setUuid(UUID.randomUUID())
                .setName("User"));

        roleEntities.add(new RoleEntity()
                .setId(2L)
                .setUuid(UUID.randomUUID())
                .setName("Admin"));

        List<Role> roles = mapper.mapRoleEntitiesToRoles(roleEntities);

        for (int i = 0; i < roles.size(); i++) {
            assertEquals(roles.get(i).getId(), roleEntities.get(i).getId());
            assertEquals(roles.get(i).getUuid(), roleEntities.get(i).getUuid());
            assertEquals(roles.get(i).getName(), roleEntities.get(i).getName());
        }
    }
}
