package com.trng.response;

import com.trng.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class EmployeeResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Employee> employees;

}
