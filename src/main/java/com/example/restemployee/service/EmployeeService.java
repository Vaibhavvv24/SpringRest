package com.example.restemployee.service;

import com.example.restemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee addEmp(Employee e);

    public void deleteEmp(int id);

}
