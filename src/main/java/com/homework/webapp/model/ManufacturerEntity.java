package com.homework.webapp.model;

import com.homework.webapp.listener.ManufacturerEntityListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "manufacturers")
@EntityListeners(ManufacturerEntityListener.class)
public class ManufacturerEntity{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "manufacturer_id")
    private Long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection(targetClass=ProductEntity.class)
    @OneToMany(fetch = EAGER, mappedBy = "manufacturer", cascade = ALL)
    private List<ProductEntity> products;
}
