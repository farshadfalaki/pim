package com.farshad.aggregator.dto;

import com.farshad.aggregator.model.Statistics;

import java.util.Date;
import java.util.Objects;

public class StatisticsDto {
    private Date date;
    private int newItemsCount;
    private int updatedItemsCount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNewItemsCount() {
        return newItemsCount;
    }

    public void setNewItemsCount(int newItemsCount) {
        this.newItemsCount = newItemsCount;
    }

    public int getUpdatedItemsCount() {
        return updatedItemsCount;
    }

    public void setUpdatedItemsCount(int updatedItemsCount) {
        this.updatedItemsCount = updatedItemsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsDto that = (StatisticsDto) o;
        return newItemsCount == that.newItemsCount &&
                updatedItemsCount == that.updatedItemsCount &&
                Objects.equals(date, that.date);
    }

    @Override
    public String toString() {
        return "StatisticsDto{" +
                "date=" + date +
                ", newItemsCount=" + newItemsCount +
                ", updatedItemsCount=" + updatedItemsCount +
                '}';
    }



    public StatisticsDto(){}

    public StatisticsDto(Statistics statistics){
        if(statistics!=null){
            this.setDate(statistics.getDate());
            this.setNewItemsCount(statistics.getNewItemsCount());
            this.setUpdatedItemsCount(statistics.getUpdatedItemsCount());
        }
    }
}
