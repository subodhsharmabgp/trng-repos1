package com.trng.service;

import com.trng.exception.RecordNotFoundException;
import com.trng.model.Employee;
import com.trng.response.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    public static final String NOT_EXITS = "not exits";
    List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        var emp = findEmployee(employee.getEmpId());
        if (emp.isPresent()) {
            employeeList.remove(emp.get());
            employeeList.add(employee);
        } else {
            throw new RecordNotFoundException("" + employee.getEmpId() + NOT_EXITS);
        }
        return employee;
    }

    public EmployeeResponse getAllEmployees() {
        var employeeResponse = new EmployeeResponse();
        employeeList.sort(Comparator.comparing(Employee::getEmpId));
        employeeResponse.setEmployees(employeeList);
        return employeeResponse;
    }

    public Employee deleteAnEmployee(Integer empId) {
        var emp = findEmployee(empId);
        if (emp.isPresent()) {
            employeeList.remove(emp.get());
        } else {
            throw new RecordNotFoundException("" + empId + NOT_EXITS);
        }
        return emp.get();
    }

    public Employee getAnEmployee(Integer empId) {
        var emp = findEmployee(empId);
        if (emp.isPresent()) {
            return emp.get();
        } else {
            throw new RecordNotFoundException("" + empId + NOT_EXITS);
        }
    }

    private Optional<Employee> findEmployee(Integer empId) {
        return employeeList.stream().filter(employee -> employee.getEmpId().equals(empId)).findFirst();
    }
}
