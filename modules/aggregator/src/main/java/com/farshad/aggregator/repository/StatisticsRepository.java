package com.farshad.aggregator.repository;

import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.model.Statistics;

import java.util.Date;

public interface StatisticsRepository  {
    Statistics findByDate(Date date);
    void increaseStatisticsWithDateAndStatus(Date date, ProductProcessStatus productProcessStatus);
}
