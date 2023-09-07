package com.trng.exception;

import com.trng.model.Employee;
import com.trng.response.EmployeeResponse;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor
public class RecordNotFoundException extends RuntimeException {
    private String message;

    public RecordNotFoundException(String message) {
        this.message = message;
    }

    public ResponseEntity<Employee> getCreateEmployeeError(Employee employeeRequest) {
        return ResponseEntity.badRequest().body(employeeRequest);
    }

    public ResponseEntity<Employee> getEmployeeError(Integer empId) {
        return ResponseEntity.badRequest().body(Employee.builder().empId(empId).build());
    }
    public ResponseEntity<EmployeeResponse> getEmployeeError() {
        return ResponseEntity.badRequest().body(new EmployeeResponse());
    }
}
