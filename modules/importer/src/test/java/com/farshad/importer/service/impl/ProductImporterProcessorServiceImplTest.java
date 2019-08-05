package com.farshad.importer.service.impl;

import com.farshad.importer.service.Reader;
import com.farshad.importer.service.Writer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@RunWith(MockitoJUnitRunner.class)
public class ProductImporterProcessorServiceImplTest {

    @Mock
    Reader reader;
    @Mock
    Writer writer;
    @InjectMocks
    ProductImporterProcessorServiceImpl productImporterProcessorService;

    @Test
    public void importAndProcessLines_nullInputStream_readerAndWriterShouldNeverBeCalled() {
        //when
        productImporterProcessorService.importAndProcessLines(null);
        //then
        verify(reader,times(0)).readLine(any());
        verify(writer,times(0)).write(any());
    }

    @Test
    public void importAndProcessLines_oneHeaderLineInputStream_firstLineShouldBeSkippedAndReaderAndWriterNeverBeCalled() {
        //Given
        String initialString = "Just header Line";
        InputStream inputStream = new ByteArrayInputStream(initialString.getBytes());
        //when
        productImporterProcessorService.importAndProcessLines(inputStream);
        //then
        verify(reader,times(0)).readLine(any());
        verify(writer,times(0)).write(any());
    }

    @Test
    public void importAndProcessLines_oneHeaderLineAndOneValidLineInputStream_firstLineShouldBeSkippedAndReaderAndWriterBeCalledOnce() {
        //Given
        String initialString = "UUID,Name,Description,provider,available,MeasurementUnits\n" +
                "fccc13f1-f337-480b-9305-a5bb56bcaa11,Samsung Galaxy Mobile,smart phone,Samsung Galaxy,true,PC";
        InputStream inputStream = new ByteArrayInputStream(initialString.getBytes());
        //when
        productImporterProcessorService.importAndProcessLines(inputStream);
        //then
        verify(reader,times(1)).readLine(any());
        verify(writer,times(1)).write(any());
    }
}