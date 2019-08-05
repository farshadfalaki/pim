package com.farshad.aggregator.listener;

import com.farshad.aggregator.conf.QueueConstants;
import com.farshad.aggregator.dto.StatisticsCommandDto;
import com.farshad.aggregator.service.StatisticsCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StatisticsListener {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsListener.class);
    @Autowired
    @Qualifier("methodCallImpl")
    private StatisticsCommandService statisticsCommandService;


    @RabbitListener(queues = QueueConstants.STAT_QUEUE_NAME)
    public void receiveStatistics(StatisticsCommandDto statisticsCommandDto){
        logger.debug(">> receiveStatistics:" + statisticsCommandDto);
        statisticsCommandService.updateProductStatisticsWithDateAndStatus(statisticsCommandDto.getDate(),statisticsCommandDto.getProductProcessStatus());
        logger.debug("<< receiveStatistics:" + statisticsCommandDto);
    }
}
