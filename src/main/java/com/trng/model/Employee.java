package com.trng.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer empId;
    private String empName;
    private String empCity;
    private Double empSalary;

}
