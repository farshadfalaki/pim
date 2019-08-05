package com.farshad.aggregator.service.impl;

import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.model.Product;
import com.farshad.aggregator.repository.ProductRepository;
import com.farshad.aggregator.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public ProductProcessStatus createOrUpdateProduct(Product product) {
        logger.debug(">>createOrUpdateProduct: " +product);
        ProductProcessStatus productProcessStatus = null;
        Product fetchedProduct = productRepository.findByUuid(product.getUuid());
        if(fetchedProduct == null){
            productRepository.save(product);
            productProcessStatus = ProductProcessStatus.NEW;
        }else{
           fetchedProduct.setName(product.getName());
           fetchedProduct.setDescription(product.getDescription());
           fetchedProduct.setProvider(product.getProvider());
           fetchedProduct.setAvailable(product.isAvailable());
           fetchedProduct.setMeasurementUnits(product.getMeasurementUnits());
           productProcessStatus = ProductProcessStatus.UPDATED;
        }
        logger.debug(">>createOrUpdateProduct: " +product + " result:"+ productProcessStatus);
        return productProcessStatus;
    }

    @Override
    public List<Product> listProducts() {
        logger.debug(">>listProducts");
        List<Product> productList = productRepository.findAll();
        logger.debug("<<listProducts size=" + productList.size());
        return productList;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
