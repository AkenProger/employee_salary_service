package com.megacom.crud_service.service.impl;

import com.megacom.crud_service.dao.EmployeesRepository;
import com.megacom.crud_service.mappers.EmployeesMapper;
import com.megacom.crud_service.models.dto.EmployeesDto;
import com.megacom.crud_service.models.entities.Employees;
import com.megacom.crud_service.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    EmployeesMapper employeesMapper;

    @Override
    public EmployeesDto save(EmployeesDto employeesDto) {
        Employees employees = employeesMapper.toEntity(employeesDto);
        employees = employeesRepository.save(employees);
        return employeesMapper.toDto(employees);
    }

    @Override
    public EmployeesDto update(EmployeesDto employeesDto) {
        if (!employeesRepository.existsById(employeesDto.getId()))
            throw new RuntimeException("Сотрудник не найден!");
        Employees employees = employeesMapper.toEntity(employeesDto);
        employees = employeesRepository.save(employees);
        return employeesMapper.toDto(employees);
    }

    @Override
    public List<EmployeesDto> findAll() {
        return employeesMapper.toDtoList(employeesRepository.findAll());
    }

    @Override
    public EmployeesDto findById(Long id) {
        Employees employees = employeesRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Не найден сотрудник с таким ID номером!"));
        return employeesMapper.toDto(employees);
    }

    @Override
    public void deleteById(Long id) {
        employeesRepository.deleteById(id);
    }


}
