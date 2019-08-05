package com.farshad.aggregator.dto;


import com.farshad.aggregator.constants.ProductProcessStatus;
import com.farshad.aggregator.model.Statistics;

import java.util.Date;

public class StatisticsCommandDto {
    private Date date;
    private ProductProcessStatus productProcessStatus;

    public StatisticsCommandDto(){}

    public StatisticsCommandDto(Date date, ProductProcessStatus productProcessStatus) {
        this.date = date;
        this.productProcessStatus = productProcessStatus;
    }

    public StatisticsCommandDto(Statistics statistics){
        /*if(statistics!=null){
            this.setDate(statistics.getDate());
            this.setNewItemsCount(statistics.getNewItemsCount());
            this.setUpdatedItemsCount(statistics.getUpdatedItemsCount());
        }*/
    }

    public Date getDate() {
        return date;
    }



    public ProductProcessStatus getProductProcessStatus() {
        return productProcessStatus;
    }


}
