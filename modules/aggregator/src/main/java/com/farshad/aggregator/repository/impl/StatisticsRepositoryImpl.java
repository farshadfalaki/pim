package com.farshad.aggregator.repository.impl;

import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.model.Statistics;
import com.farshad.aggregator.repository.StatisticsJpaRepository;
import com.farshad.aggregator.repository.StatisticsRepository;
import com.farshad.aggregator.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class StatisticsRepositoryImpl implements StatisticsRepository {
    @Autowired
    StatisticsJpaRepository statisticsJpaRepository;

    @Override
    public Statistics findByDate(Date date) {
        return statisticsJpaRepository.findByDate(DateUtil.getBeginningMomentOfDay(date));
    }

    @Override
    public void increaseStatisticsWithDateAndStatus(Date date, ProductProcessStatus productProcessStatus) {
        Statistics statistics = findByDate(date);
        if (statistics==null){
            statistics = new Statistics(DateUtil.getBeginningMomentOfDay(date),0,0);
        }
        if(productProcessStatus == ProductProcessStatus.NEW){
            statistics.setNewItemsCount(statistics.getNewItemsCount()+1);
        }else if(productProcessStatus == ProductProcessStatus.UPDATED){
            statistics.setUpdatedItemsCount(statistics.getUpdatedItemsCount()+1);
        }
        statisticsJpaRepository.save(statistics);
    }
}
