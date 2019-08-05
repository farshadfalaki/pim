package com.farshad.aggregator.service;

import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.model.Product;

import java.util.List;

public interface ProductService {
    ProductProcessStatus createOrUpdateProduct(Product product);
    List<Product> listProducts();
}
