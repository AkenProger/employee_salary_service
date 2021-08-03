package com.megacom.crud_service.mappers.impl;

import com.megacom.crud_service.mappers.SalaryMapper;
import com.megacom.crud_service.models.dto.SalariesDto;
import com.megacom.crud_service.models.entities.Salaries;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SalaryMapperImpl implements SalaryMapper {
    @Override
    public SalariesDto toDto(Salaries salaries) {
        SalariesDto salariesDto = new SalariesDto();
        salariesDto.setId(salaries.getId());
        salariesDto.setSalary(salaries.getSalary());
        salariesDto.setStart_date(salaries.getStart_date());
        salariesDto.setEnd_date(salaries.getEnd_date());
        salariesDto.setEmployees(salaries.getEmployees());
        return salariesDto;
    }

    @Override
    public Salaries toEntity(SalariesDto salariesDto) {
        Salaries salaries = new Salaries();
        salaries.setId(salariesDto.getId());
        salaries.setSalary(salariesDto.getSalary());
        salaries.setStart_date(salariesDto.getStart_date());
        salaries.setEnd_date(salariesDto.getEnd_date());
        salaries.setEmployees(salariesDto.getEmployees());
        return salaries;
    }

    @Override
    public List<SalariesDto> toDtoList(List<Salaries> entities) {
        return entities.stream().map(s -> toDto(s)).collect(Collectors.toList());
    }

    @Override
    public List<Salaries> toEntityList(List<SalariesDto> dtoList) {
        return dtoList.stream().map(s -> toEntity(s)).collect(Collectors.toList());
    }
}
