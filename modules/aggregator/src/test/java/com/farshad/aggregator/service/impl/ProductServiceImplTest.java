package com.farshad.aggregator.service.impl;

import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.model.Product;
import com.farshad.aggregator.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void createOrUpdateProduct_productDoesNotExist_shouldCreateIt() {
        //given
        Product product = new Product("e1956da7-99a8-4e1a-9b15-01e337e2e7e3","OnePlus Mobile","smart phone","OnePlus",true,"PC");
        when(productRepository.findByUuid(product.getUuid())).thenReturn(null);
        //when
        ProductProcessStatus actualProductProcessStatus = productService.createOrUpdateProduct(product);
        //then
        assertEquals(ProductProcessStatus.NEW,actualProductProcessStatus);
        verify(productRepository).findByUuid(product.getUuid());
        verify(productRepository).save(product);
    }

    @Test
    public void createOrUpdateProduct_productExists_shouldUpdateIt() {
        //given
        Product product = new Product("e1956da7-99a8-4e1a-9b15-01e337e2e7e3","OnePlus Mobile","smart phone","OnePlus",true,"PC");
        when(productRepository.findByUuid(product.getUuid())).thenReturn(product);
        //when
        ProductProcessStatus actualProductProcessStatus = productService.createOrUpdateProduct(product);
        //then
        assertEquals(ProductProcessStatus.UPDATED,actualProductProcessStatus);
        verify(productRepository).findByUuid(product.getUuid());
        verify(productRepository,times(0)).save(product);
    }

    @Test
    public void listProducts_noProduct_shouldReturnEmptyList() {
        //given
        //when
        List<Product> productList = productService.listProducts();
        //then
        assertEquals(0,productList.size());
        verify(productRepository).findAll();
    }

    @Test
    public void listProducts_oneProduct_shouldListWithOneProduct() {
        //given
        Product product = new Product("e1956da7-99a8-4e1a-9b15-01e337e2e7e3","OnePlus Mobile","smart phone","OnePlus",true,"PC");
        when(productRepository.findAll()).thenReturn(Arrays.asList(product));
        //when
        List<Product> productList = productService.listProducts();
        //then
        assertEquals(1,productList.size());
        assertEquals(product,productList.get(0));
        verify(productRepository).findAll();
    }
}