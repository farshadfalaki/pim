package com.farshad.aggregator.controller;

import com.farshad.aggregator.dto.ProductDto;
import com.farshad.aggregator.model.Product;
import com.farshad.aggregator.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/all" ,method = RequestMethod.GET)
    public List<ProductDto> listAllProducts(){
        logger.debug(">>listAllProducts");
        List<Product>  productList = productService.listProducts();
        List<ProductDto>  productDtoList = new ArrayList<>();
        if(productList!=null){
            productDtoList = productList.stream().map(a->new ProductDto(a)).collect(Collectors.toList());
        }
        logger.debug("<<listAllProducts size="+ productDtoList.size() );
        return productDtoList;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
