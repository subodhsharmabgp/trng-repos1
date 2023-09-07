package com.trng.controller;

import com.trng.exception.RecordNotFoundException;
import com.trng.model.Employee;
import com.trng.response.EmployeeResponse;
import com.trng.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // create employee
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employeeRequest) {
        try {
            return ResponseEntity.ok(employeeService.addEmployee(employeeRequest));
        } catch (RecordNotFoundException ex) {
            return ex.getCreateEmployeeError(employeeRequest);
        }
    }

    // query an employee
    @GetMapping(value="/{empId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Employee> queryEmployee(@PathVariable(value = "empId") Integer empId) {
        try {
            return ResponseEntity.ok(employeeService.getAnEmployee(empId));
        } catch (RecordNotFoundException ex) {
            return ex.getEmployeeError(empId);
        }
    }

    // update an employee
    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employeeRequest) {
        try {
            return ResponseEntity.ok(employeeService.updateEmployee(employeeRequest));
        } catch (RecordNotFoundException ex) {
            return ex.getCreateEmployeeError(employeeRequest);
        }
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EmployeeResponse> getAllEmployee() {
        try {
            return ResponseEntity.ok(employeeService.getAllEmployees());
        } catch (RecordNotFoundException ex) {
            return ex.getEmployeeError();
        }
    }
}
