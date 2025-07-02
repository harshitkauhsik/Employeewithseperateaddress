package com.employeedata.storeindifferenttable.repository;

import com.employeedata.storeindifferenttable.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
