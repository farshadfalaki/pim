package com.farshad.aggregator.service.impl;

import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.model.Product;
import com.farshad.aggregator.service.AggregatorService;
import com.farshad.aggregator.service.ProductService;
import com.farshad.aggregator.service.StatisticsCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class AggregatorServiceImpl implements AggregatorService {
    private static final Logger logger = LoggerFactory.getLogger(AggregatorServiceImpl.class);

    @Autowired
    private ProductService productService;
    @Autowired
    @Qualifier("eventDrivenImpl")
    private StatisticsCommandService statisticsCommandService;

    @Override
    public void processProductAndUpdateStatistics(Product product) {
        logger.debug(">> processProductAndUpdateStatistics:" + product);
        ProductProcessStatus productProcessStatus = productService.createOrUpdateProduct(product);
        statisticsCommandService.updateProductStatisticsWithDateAndStatus(new Date(),productProcessStatus);
        logger.debug("<< processProductAndUpdateStatistics:" + product);
    }


}
