package com.megacom.crud_service.models.dto;

import lombok.Data;

@Data
public class EmployeesDto {
    private Long id;
    private String name;
    private String surName;
    private boolean active;
}
