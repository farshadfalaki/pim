package com.farshad.aggregator.service.impl;

import com.farshad.aggregator.conf.QueueConstants;
import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.dto.StatisticsCommandDto;
import com.farshad.aggregator.service.StatisticsCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Qualifier("eventDrivenImpl")
public class StatisticsCommandServiceEventDrivenImpl implements StatisticsCommandService {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsCommandServiceEventDrivenImpl.class);
    @Autowired
    protected RabbitTemplate rabbitTemplate;

    @Override
    public void updateProductStatisticsWithDateAndStatus(Date date, ProductProcessStatus productProcessStatus) {
        logger.debug(">>updateProductStatisticsWithDateAndStatus:" + productProcessStatus);
        rabbitTemplate.convertAndSend(QueueConstants.STAT_QUEUE_NAME, new StatisticsCommandDto(date,productProcessStatus));
        logger.debug("<<updateProductStatisticsWithDateAndStatus:" + productProcessStatus);
    }
}
