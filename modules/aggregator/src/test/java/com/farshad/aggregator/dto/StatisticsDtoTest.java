package com.farshad.aggregator.dto;

import com.farshad.aggregator.model.Statistics;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class StatisticsDtoTest {



    @Test
    public void statistics_allFilledFieldsInProduct_allFieldsShouldBeFilledInProductDto() {
        //Given
        Date date = new Date();
        Statistics statistics = new Statistics(date,10,20);
        StatisticsDto expectedStatisticsDto = new StatisticsDto();
        expectedStatisticsDto.setDate(date);
        expectedStatisticsDto.setNewItemsCount(statistics.getNewItemsCount());
        expectedStatisticsDto.setUpdatedItemsCount(statistics.getUpdatedItemsCount());
        //when
        StatisticsDto actualStatisticsDto = new StatisticsDto(statistics);
        //then
        assertEquals(expectedStatisticsDto,actualStatisticsDto);

    }

    @Test
    public void statistics_nullStatistics_shouldReturnEmptyStatisticsDto() {
        //Given
        Statistics statistics = null;
        StatisticsDto expectedStatisticsDto = new StatisticsDto();

        //when
        StatisticsDto actualStatisticsDto = new StatisticsDto(statistics);
        //then
        assertEquals(actualStatisticsDto,expectedStatisticsDto);

    }

}