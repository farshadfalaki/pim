package com.farshad.importer.service.impl;

import com.farshad.importer.dto.ProductDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductReaderImplTest {

    ProductReaderImpl productReader = new ProductReaderImpl();

    @Test
    public void readLine_nullInput_shouldReturnNull() {
        //Given
        String input = null;
        //When
        ProductDto actualProductDto = productReader.readLine(input);
        //Then
        assertNull(actualProductDto);
    }

    @Test
    public void readLine_insufficientValuesInput_shouldReturnNull() {
        //Given
        String input = "6a227cf5-34e4-4f48-a77c-63576929aecd,Nokia Mobile,smart phone,Nokia,true";
        //When
        ProductDto actualProductDto = productReader.readLine(input);
        //Then
        assertNull(actualProductDto);
    }

    @Test
    public void readLine_sufficientValuesInput_shouldReturnNull() {
        //Given
        String input = "6a227cf5-34e4-4f48-a77c-63576929aecd,Nokia Mobile,smart phone,Nokia,true,PC";
        ProductDto expectedProductDto = new ProductDto("6a227cf5-34e4-4f48-a77c-63576929aecd","Nokia Mobile","smart phone","Nokia",true,"PC");
        //When
        ProductDto actualProductDto = productReader.readLine(input);
        //Then
        assertEquals(expectedProductDto,actualProductDto);
    }
}