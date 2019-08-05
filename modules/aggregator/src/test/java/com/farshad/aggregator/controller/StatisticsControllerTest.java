package com.farshad.aggregator.controller;

import com.farshad.aggregator.dto.StatisticsDto;
import com.farshad.aggregator.model.Statistics;
import com.farshad.aggregator.service.StatisticsQueryService;
import com.farshad.aggregator.util.DateUtil;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StatisticsController.class)
public class StatisticsControllerTest {
    @MockBean
    StatisticsQueryService statisticsQueryService;
    @Autowired
    private MockMvc mockMvc;
    private Gson gson;
    @Before
    public void init(){
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }
    @Test
    public void getStatisticsForToday_noStatistics_shouldReturnZeroCounts() throws Exception {
        //given
        //Date date = new Date();
        //Statistics statistics = new Statistics(date,0,0);
       // when(statisticsService.getStatistics(date)).thenReturn(statistics);
        StatisticsDto expectedStatisticsDto = new StatisticsDto();
        //when then
        mockMvc.perform(get("/stat").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("new_items_count",is(expectedStatisticsDto.getNewItemsCount())))
                .andExpect(jsonPath("updated_items_count",is(expectedStatisticsDto.getUpdatedItemsCount())))
        ;
    }

    @Test
    public void getStatisticsForToday_havingStatistics_shouldReturnAtLeastOneNonZeroCount() throws Exception {
        //given
        Date date = DateUtil.getBeginningMomentOfDay(new Date());
        Statistics statistics = new Statistics(date,10,20);
        when(statisticsQueryService.getStatistics(date)).thenReturn(statistics);
        StatisticsDto expectedStatisticsDto = new StatisticsDto(statistics);
        //when then
        mockMvc.perform(get("/stat").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
               .andExpect(jsonPath("new_items_count",is(expectedStatisticsDto.getNewItemsCount())))
               .andExpect(jsonPath("updated_items_count",is(expectedStatisticsDto.getUpdatedItemsCount())))

        ;
        verify(statisticsQueryService).getStatistics(date);
    }

}