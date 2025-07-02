package com.employeedata.storeindifferenttable.service;

import com.employeedata.storeindifferenttable.entity.Employee;
import com.employeedata.storeindifferenttable.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepo r1;
     public Employee saveEmployee(Employee e1)
     {
         return r1.save(e1);
     }
     public List<Employee> getAllEmployee()
     {
             return r1.findAll();
     }

     public Optional<Employee> getEmpById(Long id)
     {
         return r1.findById(id);

     }
     public Employee updateEmployee(Long id ,Employee updatedemployee)     //basically upating employee while accessing employee by id and updatedemployee is new data for updation
     {
         Optional<Employee> optionalemployee=r1.findById(id);//we are using optional because there are chances that employee with the given id is exist or not
         if(optionalemployee.isPresent())
         {
             Employee existingEmployee=optionalemployee.get();
             existingEmployee.setName(updatedemployee.getName());
             existingEmployee.setSalary(updatedemployee.getSalary());
             existingEmployee.setAge(updatedemployee.getAge());
             existingEmployee.setMailId(updatedemployee.getMailId());
             existingEmployee.setDoj(updatedemployee.getDoj());
             existingEmployee.setAddress(updatedemployee.getAddress());//will update nested address too automatically
             return r1.save(existingEmployee);
         }
         else
         {
             return null;
         }
     }
     public void deleteEmployeeById(Long id)
     {
         r1.deleteById(id);
     }


}
