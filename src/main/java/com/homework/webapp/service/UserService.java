package com.homework.webapp.service;

import com.homework.webapp.dto.User;
import com.homework.webapp.exception.NotFoundEntityException;
import com.homework.webapp.mapper.UserMapper;
import com.homework.webapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements BaseService<User> {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public void createOne(User user) {
        repository.save(mapper.mapUserToUserEntity(user));
    }

    @Override
    public void updateOne(User user) {
        repository.save(mapper.mapUserToUserEntity(user));
    }

    @Override
    public void deleteOneById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User findOneById(Long id) throws NotFoundEntityException {
        return mapper.mapUserEntityToUser(repository.findById(id).orElseThrow(NotFoundEntityException::new));
    }

    public User findOneByEmail(String email) throws NotFoundEntityException {
        return mapper.mapUserEntityToUser(repository.findByEmail(email).orElseThrow(NotFoundEntityException::new));
    }

    @Override
    public List<User> findAll() {
        return mapper.mapUserEntitiesToUsers(repository.findAll());
    }
}
