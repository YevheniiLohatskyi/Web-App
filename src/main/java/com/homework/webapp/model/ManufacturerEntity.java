package com.homework.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
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
public class ManufacturerEntity{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "manufacturer_id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection(targetClass=ProductEntity.class)
    @OneToMany(fetch = EAGER, mappedBy = "manufacturer", cascade = ALL)
    private Set<ProductEntity> products;
}
