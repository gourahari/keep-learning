package com.goura.spring.data;

public interface Constants {

    String FIRST_NAME = "firstName";
    String LAST_NAME = "lastName";
    String MANAGER = "Manager";

    String BASE_URL = "/company";
    String EMPLOYEES_URL = BASE_URL + "/employees";
    String EMPLOYEES_BY_ID_URL = EMPLOYEES_URL + "/id/%d";
}
