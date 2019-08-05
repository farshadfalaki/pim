package com.farshad.aggregator.service.impl;

import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.repository.StatisticsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Date;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsCommandServiceImplTest {

    @Mock
    StatisticsRepository statisticsRepository;
    @InjectMocks
    StatisticsCommandServiceMethodCallImpl statisticsService;

    @Test
    public void updateProductStatisticsWithStatus_withNewStatus_shouldUpdateNewStatistic() {
        //given
        Date date = new Date();
        ProductProcessStatus productProcessStatus = ProductProcessStatus.NEW;
        //when
        statisticsService.updateProductStatisticsWithDateAndStatus(date,productProcessStatus);
        //then
        verify(statisticsRepository).increaseStatisticsWithDateAndStatus(date,productProcessStatus);
    }

    @Test
    public void updateProductStatisticsWithStatus_withUpdatedStatus_shouldUpdateUpdatedStatistic() {
        //given
        Date date = new Date();
        ProductProcessStatus productProcessStatus = ProductProcessStatus.UPDATED;
        //when
        statisticsService.updateProductStatisticsWithDateAndStatus(date,productProcessStatus);
        //then
    }
}