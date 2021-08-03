package com.megacom.crud_service.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Salaries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double salary;
    private Date start_date;
    private Date end_date;
    @OneToOne
    @JoinColumn(name = "employees_id")
    private Employees employees;

}
