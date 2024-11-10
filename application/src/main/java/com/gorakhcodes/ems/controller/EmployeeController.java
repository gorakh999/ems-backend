package com.gorakhcodes.ems.controller;

import com.gorakhcodes.ems.dto.EmployeeDTO;
import com.gorakhcodes.ems.exception.ResourceNotFoundException;
import com.gorakhcodes.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    // Add Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get Employee By ID
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO savedEmployee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Employee Management System";
    }
}
