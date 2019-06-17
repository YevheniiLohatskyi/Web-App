package com.homework.webapp.model;

import com.homework.webapp.listener.RoleEntityListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "roles")
@EntityListeners(RoleEntityListener.class)
public class RoleEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String name;
}
