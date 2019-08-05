package com.farshad.importer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("provider")
    private String provider;
    @JsonProperty("available")
    private boolean available;
    @JsonProperty("measurement_units")
    private String measurementUnits;

    public ProductDto(String uuid, String name, String description, String provider, boolean available, String measurementUnits) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.provider = provider;
        this.available = available;
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
