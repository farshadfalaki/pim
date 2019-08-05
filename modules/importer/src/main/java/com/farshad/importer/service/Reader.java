package com.farshad.importer.service;

public interface Reader<T> {
    T readLine(String line);
}
