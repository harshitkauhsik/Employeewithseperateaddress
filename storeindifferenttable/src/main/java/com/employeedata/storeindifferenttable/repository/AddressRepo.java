package com.employeedata.storeindifferenttable.repository;

import com.employeedata.storeindifferenttable.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {
}
