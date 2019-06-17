package com.homework.webapp.service;

import com.homework.webapp.dto.Role;
import com.homework.webapp.exception.NotFoundEntityException;
import com.homework.webapp.mapper.RoleMapper;
import com.homework.webapp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleService implements BaseService<Role>{
    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public void createOne(Role role) {
        repository.save(mapper.mapRoleToRoleEntity(role));
    }

    @Override
    public void updateOne(Role role) {
        repository.save(mapper.mapRoleToRoleEntity(role));
    }

    @Override
    public void deleteOneById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Role findOneById(Long id) throws NotFoundEntityException {
        return mapper.mapRoleEntityToRole(repository.findById(id).orElseThrow(NotFoundEntityException::new));
    }

    @Override
    public List<Role> findAll() {
        return mapper.mapRoleEntitiesToRoles(repository.findAll());
    }
}
