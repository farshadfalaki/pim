package com.farshad.importer.controller;

import com.farshad.importer.service.ProductImporterProcessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImporterController {
    private static final Logger logger = LoggerFactory.getLogger(ImporterController.class);

    @Autowired
    private ProductImporterProcessorService productImporterProcessorService;

    @RequestMapping(path = "/import",method = RequestMethod.POST)
    public void importProducts(@RequestParam("file")MultipartFile uploadedFile) {
        logger.debug(">>importProducts");
        if (uploadedFile != null) {
            try {
                productImporterProcessorService.importAndProcessLines(uploadedFile.getInputStream());
            } catch (IOException e) {
                logger.debug("importProducts while getInputStream from uploadedFile" + e.getMessage());
                e.printStackTrace();
            }
        }else{
            logger.debug("importProducts file is null");
        }
        logger.debug("<<importProducts");
    }
}
