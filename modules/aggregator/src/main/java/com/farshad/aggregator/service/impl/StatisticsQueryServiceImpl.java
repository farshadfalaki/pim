package com.farshad.aggregator.service.impl;

import com.farshad.aggregator.model.Statistics;
import com.farshad.aggregator.repository.StatisticsRepository;
import com.farshad.aggregator.service.StatisticsQueryService;
import com.farshad.aggregator.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StatisticsQueryServiceImpl implements StatisticsQueryService {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsQueryServiceImpl.class);
    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public Statistics getStatistics(Date date) {
        logger.debug(">>getStatistics:" + date);
        Statistics statistics = null;
        Date beginningMomentOfDay = DateUtil.getBeginningMomentOfDay(date);
        if(date!= null){
            statistics = statisticsRepository.findByDate(beginningMomentOfDay);
            if (statistics == null) {
                logger.debug(" getStatistics: no stats for " + beginningMomentOfDay + " new empty one has be created");
                statistics = new Statistics(beginningMomentOfDay, 0, 0);
            }
        }
        logger.debug(">>getStatistics:" + date + statistics);
        return statistics;
    }

    public void setStatisticsRepository(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }
}
