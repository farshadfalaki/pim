package com.farshad.aggregator.service;


import com.farshad.aggregator.model.Statistics;

import java.util.Date;

public interface StatisticsQueryService {
    Statistics getStatistics(Date date);
}

