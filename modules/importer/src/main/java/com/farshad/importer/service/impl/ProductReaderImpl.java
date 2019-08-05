package com.farshad.importer.service.impl;

import com.farshad.importer.dto.ProductDto;
import com.farshad.importer.service.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductReaderImpl implements Reader<ProductDto> {
    private static final Logger logger = LoggerFactory.getLogger(ProductReaderImpl.class);
    @Override
    public ProductDto readLine(String line) {
        ProductDto productDto = null;
        if(line!=null){
            String[] splittedArr = line.split(",");
            if(splittedArr.length==6){
                productDto = new ProductDto(splittedArr[0],splittedArr[1],splittedArr[2],splittedArr[3],"true".equals(splittedArr[4]),splittedArr[5]);

            }else{
                logger.debug("Line omitted :" + line);
            }
        }
        return productDto;
    }
}
