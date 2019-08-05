package com.farshad.aggregator.service.impl;

import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.repository.StatisticsRepository;
import com.farshad.aggregator.service.StatisticsCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Qualifier("methodCallImpl")
public class StatisticsCommandServiceMethodCallImpl implements StatisticsCommandService {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsCommandServiceMethodCallImpl.class);
    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    @Transactional
    public void updateProductStatisticsWithDateAndStatus(Date date, ProductProcessStatus productProcessStatus) {
        logger.debug(">>updateProductStatisticsWithDateAndStatus:" + productProcessStatus);
        statisticsRepository.increaseStatisticsWithDateAndStatus(date,productProcessStatus);
        logger.debug("<<updateProductStatisticsWithDateAndStatus:" + productProcessStatus);
    }


}
