package com.services;

import java.util.List;

public interface Service<T> {

    public List<T> getDataList() throws Exception;
    public String testProcOutput() throws Exception;
}
