package com.homework.webapp.controller;

import com.homework.webapp.dto.Manufacturer;
import com.homework.webapp.dto.Product;
import com.homework.webapp.exception.NotFoundEntityException;
import com.homework.webapp.mapper.ManufacturerMapper;
import com.homework.webapp.mapper.ProductMapper;
import com.homework.webapp.service.ManufacturerService;
import com.homework.webapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.homework.webapp.util.ProductCheckUtil.isProductOfThisManufacturer;


@Controller
@RequestMapping("/manufacturers/{manufacturer_id}/products")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
    private final ProductService productService;
    private final ManufacturerService manufacturerService;
    private final ProductMapper productMapper;
    private final ManufacturerMapper manufacturerMapper;

    @GetMapping(path = "/")
    public List<Product> getAllProducts(@PathVariable(value = "manufacturer_id") Long manufacturerId) throws NotFoundEntityException {
        Manufacturer manufacturer = manufacturerService.findOneById(manufacturerId);
        return productMapper.mapProductEntitiesToProducts(manufacturer.getProducts());
    }

    @PostMapping(path = "/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Product> createProduct(Product product,
                                @PathVariable(value = "manufacturer_id") Long manufacturerId) throws NotFoundEntityException {
        product.setManufacturer(manufacturerMapper
                .mapManufacturerToManufacturerEntity(manufacturerService
                        .findOneById(manufacturerId)));
        productService.createOne(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(path = "/edit/{product_id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Product> editProduct(@RequestBody Product product,
                                                 @PathVariable(value = "manufacturer_id") Long manufacturerId,
                                                 @PathVariable(value = "product_id") Long productId) throws NotFoundEntityException {
        if (isProductOfThisManufacturer(manufacturerId, manufacturerService, productId, productService)) {
            productService.updateOne(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/delete/{product_id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "manufacturer_id") Long manufacturerId,
                                                       @PathVariable(value = "product_id") Long productId) throws NotFoundEntityException {
        if (isProductOfThisManufacturer(manufacturerId, manufacturerService, productId, productService)) {
            productService.deleteOneById(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
