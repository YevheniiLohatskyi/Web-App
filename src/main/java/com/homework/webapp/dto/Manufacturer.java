package com.homework.webapp.dto;

import com.homework.webapp.model.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Manufacturer {
    private Long id;

    private UUID uuid;

    private String name;

    private List<ProductEntity> products;
}
