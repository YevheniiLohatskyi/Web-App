package com.homework.webapp.model;

import com.homework.webapp.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "users")
public class UserEntity {
    private UUID id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
}
