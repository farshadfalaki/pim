package com.farshad.aggregator.service;


import com.farshad.aggregator.constants.ProductProcessStatus;

import java.util.Date;

public interface StatisticsCommandService {
    void updateProductStatisticsWithDateAndStatus(Date date, ProductProcessStatus productProcessStatus);
}

