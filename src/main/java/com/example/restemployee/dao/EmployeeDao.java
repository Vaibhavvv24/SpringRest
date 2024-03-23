package com.example.restemployee.dao;

import com.example.restemployee.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee addEmp(Employee e);

    public void deleteEmp(int id);

}
