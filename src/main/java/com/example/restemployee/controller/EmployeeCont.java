package com.example.restemployee.controller;

import com.example.restemployee.dao.EmployeeDao;
import com.example.restemployee.entity.Employee;
import com.example.restemployee.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiTemplateEditor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeCont {
    private EmployeeService es;     //here we call service instead of calling the dao directly
    //we will have to inject es using constructor injection
    @Autowired
    public EmployeeCont(EmployeeService es) {
        this.es = es;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return es.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmpbyId(@PathVariable int id){
        Employee e=es.findById(id);
        if(e==null){
            throw new RuntimeException("Sorry no employee available");
        }
        return  e;
    }
    @PostMapping("/employees")
    public Employee add(@RequestBody Employee e){
        //using this method for creating a new employee
        //also if the give id we will set it to 0 to ensure new employee being added
        e.setId(0);
        Employee dbe=es.addEmp(e);
        return dbe;

    }
    @PutMapping("/employees")       //assuming that user will give employee id as well in the request(not a good way ask someone)
    public Employee update(@RequestBody Employee e){
        Employee dbEmployee=es.addEmp(e);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id){
        Employee e=es.findById(id);
        if(e==null){
            throw new RuntimeException("Employee cannot be deleted as not in db");
        }

        es.deleteEmp(id);
        return "Employee deleted with id "+(id);
    }
}
