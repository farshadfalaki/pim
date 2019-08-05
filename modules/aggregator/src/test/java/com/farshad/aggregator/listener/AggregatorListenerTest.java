package com.farshad.aggregator.listener;

import com.farshad.aggregator.dto.ProductDto;
import com.farshad.aggregator.model.Product;
import com.farshad.aggregator.service.AggregatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AggregatorListenerTest {

    @Mock
    AggregatorService aggregatorService;
    @InjectMocks
    AggregatorListener aggregatorListener;
    @Test
    public void receiveProduct_receivedProduct_shouldBeProcessed() {
        //given
        ProductDto productDto = new ProductDto();
        Product product = new Product();
        //when
        aggregatorListener.receiveProduct(productDto);
        //then
        verify(aggregatorService).processProductAndUpdateStatistics(product);
    }
}