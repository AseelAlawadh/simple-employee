package com.example.payroll.services;

import com.example.payroll.entities.EmployeeEntity;
import com.example.payroll.enums.EmployeeStatus;
import com.example.payroll.repostories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }
    public EmployeeEntity createEmployeeWithData() {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setName("Alex");
        employee.setRole("Software eng");
        employee.setStatus(EmployeeStatus.NOT_PAID);
        employee.setSalary(4000);
        return employeeRepository.save(employee);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<EmployeeEntity> getAllEmployeeOrderedBySalary(){
        return employeeRepository.findAllByOrderBySalaryDesc();
    }

    public EmployeeEntity getEmployeeWithMaxSalary(){
        List<EmployeeEntity> employeeEntities = getAllEmployeeOrderedBySalary();
        return employeeEntities.isEmpty() ? null : employeeEntities.get(0);
    }
    public EmployeeEntity getEmployeeById(Long id){
        Optional<EmployeeEntity> payroll = employeeRepository.findById(id);
        return payroll.orElseThrow(() -> new EmptyStackException());
    }

    public EmployeeEntity updateEmployee(EmployeeEntity newEmployee){
        return employeeRepository.findById(newEmployee.getId()).map(
                employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    employee.setSalary(newEmployee.getSalary());
                    employee.setStatus(newEmployee.getStatus());
                    return employeeRepository.save(employee);
                }
        ).orElseGet(()->{
                newEmployee.setId(newEmployee.getId());
        return employeeRepository.save(newEmployee);}
        );
    }

    public void deleteEmployee(Long id){
         employeeRepository.deleteById(id);
    }
}
