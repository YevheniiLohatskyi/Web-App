package com.homework.webapp.util;

import com.homework.webapp.dto.Manufacturer;
import com.homework.webapp.dto.Product;
import com.homework.webapp.exception.NotFoundEntityException;
import com.homework.webapp.mapper.ProductMapper;
import com.homework.webapp.service.ManufacturerService;
import com.homework.webapp.service.ProductService;

public class ProductCheckUtil {
    private static final ProductMapper PRODUCT_MAPPER = new ProductMapper();

    public static boolean isProductOfThisManufacturer(Long manufacturerId, ManufacturerService producerService,
                                                  Long productId, ProductService productService) throws NotFoundEntityException {
        Manufacturer manufacturer = producerService.findOneById(manufacturerId);
        Product product = productService.findOneById(productId);
        return manufacturer
                .getProducts()
                .contains(PRODUCT_MAPPER.mapProductToProductEntity(product)) || product.getManufacturer().getId().equals(manufacturerId);
    }
}
