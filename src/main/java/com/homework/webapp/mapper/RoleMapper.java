package com.homework.webapp.mapper;

import com.homework.webapp.dto.Role;
import com.homework.webapp.model.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {
    public Role mapRoleEntityToRole(RoleEntity entity){
        return new Role()
                .setId(entity.getId())
                .setName(entity.getName());
    }

    public List<Role> mapRoleEntitiesToRoles(List<RoleEntity> entities){
        return entities.stream()
                .map(this::mapRoleEntityToRole)
                .collect(Collectors.toList());
    }

    public RoleEntity mapRoleToRoleEntity(Role role){
        return new RoleEntity()
                .setId(role.getId())
                .setName(role.getName());
    }
}
