package com.farshad.aggregator.repository;

import com.farshad.aggregator.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    Product findByUuid(String uuid);
}
