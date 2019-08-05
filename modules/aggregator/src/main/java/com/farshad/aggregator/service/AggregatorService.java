package com.farshad.aggregator.service;


import com.farshad.aggregator.model.Product;

public interface AggregatorService {
    void processProductAndUpdateStatistics(Product product);
}
