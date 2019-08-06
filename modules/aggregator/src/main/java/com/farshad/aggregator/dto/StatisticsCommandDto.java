package com.farshad.aggregator.dto;


import com.farshad.aggregator.constants.ProductProcessStatus;
import java.util.Date;

public class StatisticsCommandDto {
    private Date date;
    private ProductProcessStatus productProcessStatus;

    public StatisticsCommandDto(){}

    public StatisticsCommandDto(Date date, ProductProcessStatus productProcessStatus) {
        this.date = date;
        this.productProcessStatus = productProcessStatus;
    }

    public Date getDate() {
        return date;
    }

    public ProductProcessStatus getProductProcessStatus() {
        return productProcessStatus;
    }


}
