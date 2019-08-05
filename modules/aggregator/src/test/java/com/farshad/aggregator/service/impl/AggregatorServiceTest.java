package com.farshad.aggregator.service.impl;

import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.model.Product;
import com.farshad.aggregator.service.ProductService;
import com.farshad.aggregator.service.StatisticsCommandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class AggregatorServiceTest {
    @Mock
    ProductService productService;
    @Mock
    StatisticsCommandService statisticsCommandService;
    @InjectMocks
    AggregatorServiceImpl aggregatorService;

    @Test
    public void processProductAndUpdateStatistics_withNewProduct_shouldUpdateProductStatisticsWithNew(){
        //Given
        Product product = new Product("e1956da7-99a8-4e1a-9b15-01e337e2e7e3","OnePlus Mobile","smart phone","HTC",true,"PC");
        when(productService.createOrUpdateProduct(product)).thenReturn(ProductProcessStatus.NEW);
        //When
        aggregatorService.processProductAndUpdateStatistics(product);
        //Then
        verify(productService).createOrUpdateProduct(product);
        verify(statisticsCommandService).updateProductStatisticsWithDateAndStatus(any(),eq(ProductProcessStatus.NEW));
    }
    @Test
    public void processProductAndUpdateStatistics_withExistingProduct_shouldUpdateProductStatisticsWithUpdated(){
        //Given
        Product product = new Product("e1956da7-99a8-4e1a-9b15-01e337e2e7e3","OnePlus Mobile","smart phone","OnePlus",true,"PC");
        when(productService.createOrUpdateProduct(product)).thenReturn(ProductProcessStatus.UPDATED);
        //When
        aggregatorService.processProductAndUpdateStatistics(product);
        //Then
        verify(productService).createOrUpdateProduct(product);
        verify(statisticsCommandService).updateProductStatisticsWithDateAndStatus(any(),eq(ProductProcessStatus.UPDATED));
    }

}