package com.homework.webapp.dto;

import com.homework.webapp.model.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    private UUID id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private RoleEntity role;
}
