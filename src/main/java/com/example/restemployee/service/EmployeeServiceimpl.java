package com.example.restemployee.service;

import com.example.restemployee.dao.EmployeeDao;
import com.example.restemployee.dao.EmployeeDaoimpl;
import com.example.restemployee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service        //kind of acts as a intermediary between dao and rest controller
public class EmployeeServiceimpl implements EmployeeService{

    private EmployeeDao edao;
    //the edao is now injected using constructor in the service instead of the controller
@Autowired
    public EmployeeServiceimpl(EmployeeDao edao) {
        this.edao = edao;
    }

    public List<Employee> findAll(){
        return edao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return edao.findById(id);
    }

    @Override
    @Transactional
    public void deleteEmp(int id) {
         edao.deleteEmp(id);
    }

    @Override
    @Transactional   //we have added this in service layer instead of repository layer
    public Employee addEmp(Employee e) {
        return edao.addEmp(e);
    }
}
