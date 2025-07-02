package com.employeedata.storeindifferenttable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  //no need to set getters and  setters
@NoArgsConstructor//no need to write constructors
@AllArgsConstructor
public class Employee {

    @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private int salary;
    private int age;
    private String mailId;
    private String doj;

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="address_id",referencedColumnName = "id")
    private Address address;


}
