package com.farshad.aggregator.dto;

import com.farshad.aggregator.model.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductDtoTest {

    @Test
    public void toProduct_allFilledFieldsInProductDto_allFieldsShouldBeFilledInProduct() {
        //given
        ProductDto productDto = new ProductDto();
        productDto.setUuid("e1956da7-99a8-4e1a-9b15-01e337e2e7e3");
        productDto.setName("OnePlus Mobile");
        productDto.setDescription("smart phone");
        productDto.setProvider("HTC");
        productDto.setAvailable(true);
        productDto.setMeasurementUnits("PC");
        Product expectedProduct = new Product(productDto.getUuid(),productDto.getName(),productDto.getDescription(),productDto.getProvider(),productDto.isAvailable(),productDto.getMeasurementUnits());
        //when
        Product actualProduct = productDto.toProduct();
        //then
        assertEquals(actualProduct,expectedProduct);
    }


    @Test
    public void product_allFilledFieldsInProduct_allFieldsShouldBeFilledInProductDto() {
        //Given
        Product product = new Product("e1956da7-99a8-4e1a-9b15-01e337e2e7e3","OnePlus Mobile","smart phone","HTC",true,"PC");
        ProductDto expectedProductDto = new ProductDto();
        expectedProductDto.setUuid("e1956da7-99a8-4e1a-9b15-01e337e2e7e3");
        expectedProductDto.setName("OnePlus Mobile");
        expectedProductDto.setDescription("smart phone");
        expectedProductDto.setProvider("HTC");
        expectedProductDto.setAvailable(true);
        expectedProductDto.setMeasurementUnits("PC");
        //when
        ProductDto actualProductDto = new ProductDto(product);
        //then
        assertEquals(actualProductDto,expectedProductDto);

    }

    @Test
    public void product_nullProduct_shouldReturnEmptyProductDto() {
        //Given
        Product product = null;
        ProductDto expectedProductDto = new ProductDto();

        //when
        ProductDto actualProductDto = new ProductDto(product);
        //then
        assertEquals(actualProductDto,expectedProductDto);

    }
}