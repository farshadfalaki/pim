package com.farshad.aggregator.repository;

import com.farshad.aggregator.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface StatisticsJpaRepository extends JpaRepository<Statistics,Long> {
    Statistics findByDate(Date date);
}
