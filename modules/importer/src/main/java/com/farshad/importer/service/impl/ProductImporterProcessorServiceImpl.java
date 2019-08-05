package com.farshad.importer.service.impl;

import com.farshad.importer.dto.ProductDto;
import com.farshad.importer.service.ProductImporterProcessorService;
import com.farshad.importer.service.Reader;
import com.farshad.importer.service.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
@Service
public class ProductImporterProcessorServiceImpl implements ProductImporterProcessorService {
    private static final Logger logger = LoggerFactory.getLogger(ProductImporterProcessorServiceImpl.class);

    @Autowired
    private Reader<ProductDto> reader;
    @Autowired
    private Writer<ProductDto> writer;

    private int skipLines = 1;

    @Override
    public void importAndProcessLines(InputStream inputStream) {
        logger.debug(">>importAndProcessLines");
        BufferedReader br;
        String line;
        int readLines =0;
        if (inputStream != null) {
            try {
                br = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = br.readLine()) != null) {
                    readLines++;
                    if (skipLines < readLines) {
                        ProductDto productDto = reader.readLine(line);
                        writer.write(productDto);
                    }
                }
            } catch (IOException e) {
                logger.debug("importAndProcessLines while readLine from BufferedReader" + e.getMessage());
                e.printStackTrace();
            }
        }else{
            logger.debug("importAndProcessLines inputStream is null");
        }
        logger.debug("<<importAndProcessLines");

    }



    public void setSkipLines(int skipLines) {
        this.skipLines = skipLines;
    }
}
