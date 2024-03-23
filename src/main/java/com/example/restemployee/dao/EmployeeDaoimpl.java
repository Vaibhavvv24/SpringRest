package com.example.restemployee.dao;

import com.example.restemployee.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoimpl implements EmployeeDao{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDaoimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Employee> findAll(){
        TypedQuery<Employee> query= entityManager.createQuery("From Employee",Employee.class);

        List<Employee> employees=query.getResultList();

        return employees;

    }
    public Employee findById(int id){

        Employee e=entityManager.find(Employee.class,id);
        return e;
    }

    @Override
    public Employee addEmp(Employee e) {
        Employee employee=entityManager.merge(e);
        return employee;

    }

    @Override
    public void deleteEmp(int id) {
        Employee e=entityManager.find(Employee.class,id);
        entityManager.remove(e);
    }
}
