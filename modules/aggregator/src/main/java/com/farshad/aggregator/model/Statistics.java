package com.farshad.aggregator.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Date date;
    @Column
    private int newItemsCount;
    @Column
    private int updatedItemsCount;

    public Statistics(Date date,int newItemsCount, int updatedItemsCount) {
        this.date = date;
        this.newItemsCount = newItemsCount;
        this.updatedItemsCount = updatedItemsCount;
    }

    public Statistics() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return newItemsCount == that.newItemsCount &&
                updatedItemsCount == that.updatedItemsCount &&
                Objects.equals(id, that.id) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, newItemsCount, updatedItemsCount);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
