package com.farshad.aggregator.model;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String uuid;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String provider;
    @Column
    private boolean available;
    @Column
    private String measurementUnits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getMeasurementUnits() {
        return measurementUnits;
    }

    public void setMeasurementUnits(String measurementUnits) {
        this.measurementUnits = measurementUnits;
    }



    public Product(String uuid, String name, String description, String provider, boolean available, String measurementUnits) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.provider = provider;
        this.available = available;
        this.measurementUnits = measurementUnits;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", provider='" + provider + '\'' +
                ", available=" + available +
                ", measurementUnits='" + measurementUnits + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return available == product.available &&
                Objects.equals(id, product.id) &&
                Objects.equals(uuid, product.uuid) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(provider, product.provider) &&
                Objects.equals(measurementUnits, product.measurementUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid);
    }
}
