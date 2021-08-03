package com.megacom.crud_service.models.dto;

import com.megacom.crud_service.models.entities.Employees;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
public class SalariesDto {
    private Long id;
    private double salary;
    private Date start_date;
    private Date end_date;
    private Employees employees;
}
