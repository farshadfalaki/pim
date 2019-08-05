package com.farshad.aggregator.controller;

import com.farshad.aggregator.dto.StatisticsDto;
import com.farshad.aggregator.model.Statistics;
import com.farshad.aggregator.service.StatisticsQueryService;
import com.farshad.aggregator.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(path = "/stat")
public class StatisticsController {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);
    @Autowired
    private StatisticsQueryService statisticsQueryService;

    @RequestMapping(method = RequestMethod.GET)
    public StatisticsDto getStatisticsForToday(){
        logger.debug("getStatisticsForToday request");
        Statistics statisticsForToday = statisticsQueryService.getStatistics(DateUtil.getBeginningMomentOfDay(new Date()));
        logger.debug("convert statistics to statisticsDto ");
        StatisticsDto statisticsDto = new StatisticsDto(statisticsForToday);
        logger.debug("statisticsForToday :" +  statisticsForToday);
        return statisticsDto;
    }

    public void setStatisticsQueryService(StatisticsQueryService statisticsQueryService) {
        this.statisticsQueryService = statisticsQueryService;
    }
}
