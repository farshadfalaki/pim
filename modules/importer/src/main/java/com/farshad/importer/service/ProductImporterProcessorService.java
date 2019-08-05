package com.farshad.importer.service;

import java.io.InputStream;

public interface ProductImporterProcessorService {
    void importAndProcessLines(InputStream inputStream);
}
