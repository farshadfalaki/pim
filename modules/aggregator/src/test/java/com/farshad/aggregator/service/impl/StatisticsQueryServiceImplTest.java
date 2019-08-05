package com.farshad.aggregator.service.impl;

import com.farshad.aggregator.model.Statistics;
import com.farshad.aggregator.repository.StatisticsRepository;
import com.farshad.aggregator.util.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsQueryServiceImplTest {

    @Mock
    StatisticsRepository statisticsRepository;
    @InjectMocks
    StatisticsQueryServiceImpl statisticsService;

    @Test
    public void getStatistics_withNullDate_shouldReturnNull() {
        //given
        Date date = null;
        Statistics expectedStatistics = null;
        //when
        Statistics actualStatistics = statisticsService.getStatistics(date);
        //then
        Assert.assertEquals(expectedStatistics,actualStatistics);
    }

    @Test
    public void getStatistics_withDateNotHavingStatistics_shouldReturnEmptyStatistics() {
        //given
        Date date = new Date();
        Statistics expectedStatistics = new Statistics();
        expectedStatistics.setDate(DateUtil.getBeginningMomentOfDay(date));
        when(statisticsRepository.findByDate(DateUtil.getBeginningMomentOfDay(date))).thenReturn(null);
        //when
        Statistics actualStatistics = statisticsService.getStatistics(date);
        //then
        Assert.assertEquals(expectedStatistics,actualStatistics);
    }

    @Test
    public void getStatistics_withDateHavingStatistics_shouldReturnValidStatistics() {
        //given
        Date date = new Date();
        Statistics expectedStatistics = new Statistics(date,200,100);
        when(statisticsRepository.findByDate(DateUtil.getBeginningMomentOfDay(date))).thenReturn(expectedStatistics);
        //when
        Statistics actualStatistics = statisticsService.getStatistics(date);
        //then
        Assert.assertEquals(expectedStatistics,actualStatistics);
    }


}