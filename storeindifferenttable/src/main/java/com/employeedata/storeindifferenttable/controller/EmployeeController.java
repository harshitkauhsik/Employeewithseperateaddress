package com.employeedata.storeindifferenttable.controller;


import com.employeedata.storeindifferenttable.entity.Employee;
import com.employeedata.storeindifferenttable.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService s1;
    @PostMapping
    public Object createEmplpyee(@RequestBody Employee e1)
    {
        s1.saveEmployee(e1);
        System.out.println("The employe "+e1.getName()+" has been saved.");
        return "The employee "+e1.getName()+" has been saved with employee id "+e1.getId();
    }
    @GetMapping
    public List<Employee> getEmployee()
    {
        System.out.println(s1.getAllEmployee());
        return s1.getAllEmployee();
    }
    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id)
    {
        Optional<Employee> optionalemployee = s1.getEmpById(id);
        {
            if(optionalemployee.isPresent())
          {
              return optionalemployee.get();
          }
            else
            {
                return "Employee with id "+id+" is not persent";
            }
        }
    }
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id,@RequestBody Employee updatedemployee)
    {
          Employee check=s1.updateEmployee(id,updatedemployee);
       if(check!=null)
       {
           return "Employee with id "+id+" has been updated.";
       }
       else
       {
           return "Employee does't update";
       }
    }
    @DeleteMapping("/{id}")
     public String deleteEmployee(@PathVariable() Long id)
    {
        Optional<Employee>check=s1.getEmpById(id);
        if(check.isPresent())
        {
            s1.deleteEmployeeById(id);
            return "The employee with id "+id+" has been deleted.";
        }
        else
        {
            return "Employee with id"+id+" does't exist";
        }
    }
}
