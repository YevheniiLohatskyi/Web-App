package com.homework.webapp.service;

import com.homework.webapp.dto.Product;
import com.homework.webapp.exception.NotFoundEntityException;
import com.homework.webapp.mapper.ProductMapper;
import com.homework.webapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService implements BaseService<Product> {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public void createOne(Product product) {
        repository.save(mapper.mapProductToProductEntity(product));
    }

    @Override
    public void updateOne(Product product) {
        repository.save(mapper.mapProductToProductEntity(product));
    }

    @Override
    public void deleteOneById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Product findOneById(Long id) throws NotFoundEntityException {
        return mapper.mapProductEntityToProduct(repository.findById(id).orElseThrow(NotFoundEntityException::new));
    }

    @Override
    public List<Product> findAll() {
        return mapper.mapProductEntitiesToProducts(repository.findAll());
    }
}
