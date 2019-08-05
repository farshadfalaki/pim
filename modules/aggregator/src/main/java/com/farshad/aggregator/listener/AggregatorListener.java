package com.farshad.aggregator.listener;

import com.farshad.aggregator.conf.QueueConstants;
import com.farshad.aggregator.dto.ProductDto;
import com.farshad.aggregator.service.AggregatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AggregatorListener {
    private static final Logger logger = LoggerFactory.getLogger(AggregatorListener.class);

    @Autowired
    private AggregatorService aggregatorService;

    public void setAggregatorService(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }
    @RabbitListener(queues = QueueConstants.PRODUCT_QUEUE_NAME)
    public void receiveProduct(ProductDto productDto){
        logger.debug(">> receiveProduct:" + productDto);
        aggregatorService.processProductAndUpdateStatistics(productDto.toProduct());
        logger.debug("<< receiveProduct:" + productDto);
    }
}
