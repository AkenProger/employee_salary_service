package com.megacom.crud_service.mappers.impl;

import com.megacom.crud_service.mappers.EmployeesMapper;
import com.megacom.crud_service.models.dto.EmployeesDto;
import com.megacom.crud_service.models.entities.Employees;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesMapperImpl implements EmployeesMapper {
    @Override
    public EmployeesDto toDto(Employees employees) {
        EmployeesDto employeesDto = new EmployeesDto();
        employeesDto.setId(employees.getId());
        employeesDto.setName(employees.getName());
        employeesDto.setSurName(employees.getSurName());
        employeesDto.setActive(employees.isActive());
        return employeesDto;
    }

    @Override
    public Employees toEntity(EmployeesDto employeesDto) {
        Employees employees = new Employees();

        employees.setId(employeesDto.getId());
        employees.setName(employeesDto.getName());
        employees.setSurName(employeesDto.getSurName());
        employees.setActive(employeesDto.isActive());

        return employees;
    }

    @Override
    public List<EmployeesDto> toDtoList(List<Employees> entities) {
        return entities.stream().map(s -> toDto(s)).collect(Collectors.toList());
    }

    @Override
    public List<Employees> toEntityList(List<EmployeesDto> dtoList) {
        return dtoList.stream().map(s -> toEntity(s)).collect(Collectors.toList());
    }
}
