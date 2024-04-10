package com.example.payroll.controllers;

import com.example.payroll.entities.EmployeeEntity;
import com.example.payroll.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee){
        EmployeeEntity createdEmployee = employeeService.createEmployee(employee);
        return createdEmployee;
    }
    @PostMapping("/data")
    public ResponseEntity<EmployeeEntity> createEmployeeWithData(){
        return ResponseEntity.ok(employeeService.createEmployeeWithData());
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/sorted")
    public List<EmployeeEntity> getSortedEmployees(){
        return employeeService.getAllEmployeeOrderedBySalary();
    }

    @GetMapping("max-salary")
    public EmployeeEntity getEmployeeWithMaxSalary(){
        return employeeService.getEmployeeWithMaxSalary();
    }
    @GetMapping("/{id}")
    public EmployeeEntity getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employee){
        employee.setId(id);
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}
