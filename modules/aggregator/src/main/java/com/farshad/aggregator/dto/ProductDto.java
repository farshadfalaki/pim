package com.farshad.aggregator.dto;

import com.farshad.aggregator.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private String uuid;
    private String name;
    private String description;
    private String provider;
    private boolean available;
    @JsonProperty("measurement_units")
    private String measurementUnits;

    public Product toProduct() {
        Product product = new Product(this.getUuid(),this.getName(),this.getDescription(),this.getProvider(),this.isAvailable(),this.getMeasurementUnits());
        return product;
    }
    public ProductDto() {}
    public ProductDto(Product product) {
        if(product!=null) {
            this.uuid = product.getUuid();
            this.name = product.getName();
            this.description = product.getDescription();
            this.provider = product.getProvider();
            this.available = product.isAvailable();
            this.measurementUnits = product.getMeasurementUnits();
        }
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

    @Override
    public String toString() {
        return "ProductDto{" +
                "uuid='" + uuid + '\'' +
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
        ProductDto that = (ProductDto) o;
        return available == that.available &&
                Objects.equals(uuid, that.uuid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(provider, that.provider) &&
                Objects.equals(measurementUnits, that.measurementUnits);
    }


}
