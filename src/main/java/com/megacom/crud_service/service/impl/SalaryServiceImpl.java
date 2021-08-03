package com.megacom.crud_service.service.impl;

import com.megacom.crud_service.dao.SalariesRepository;
import com.megacom.crud_service.mappers.SalaryMapper;
import com.megacom.crud_service.models.dto.SalariesDto;
import com.megacom.crud_service.models.entities.Salaries;
import com.megacom.crud_service.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    SalariesRepository salariesRepository;

    @Autowired
    SalaryMapper salaryMapper;

    @Override
    public SalariesDto save(SalariesDto salariesDto) {
        Salaries salaries = salaryMapper.toEntity(salariesDto);
        salaries = salariesRepository.save(salaries);
        return salaryMapper.toDto(salaries);
    }

    @Override
    public SalariesDto update(SalariesDto salariesDto) {
        if (!salariesRepository.existsById(salariesDto.getId()))
            throw new RuntimeException("Зарплата не найден!");
        Salaries salaries = salaryMapper.toEntity(salariesDto);
        salaries = salariesRepository.save(salaries);
        return salaryMapper.toDto(salaries);
    }

    @Override
    public List<SalariesDto> findAll() {
        return salaryMapper.toDtoList(salariesRepository.findAll());
    }

    @Override
    public SalariesDto findById(Long id) {
        Salaries salaries = salariesRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Зарплата с таким ID номером не найден!"));
        return salaryMapper.toDto(salaries);
    }

    @Override
    public void deleteById(Long id) {
        salariesRepository.deleteById(id);
    }


    @Override
    public List<SalariesDto> setSalaryWhereLittleSum(double percents, double sum) {
        List<SalariesDto> salariesDtoList = salaryMapper.toDtoList(salariesRepository.findByWhereSalaryMin(sum));
        salariesDtoList.stream().map(x -> {
            Salaries salaries = new Salaries();
            double salary = x.getSalary() * percents / 100;
            salaries.setId(x.getId());
            salaries.setSalary(x.getSalary() + salary);
            salaries.setEnd_date(x.getStart_date());
            salaries.setStart_date(x.getStart_date());
            salaries.setEmployees(x.getEmployees());
            salaries = salariesRepository.save(salaries);
            return salaries;
        }).collect(Collectors.toList());
        return salariesDtoList;
    }

    @Override
    public List<SalariesDto> setPremium(double sum) {
        List<SalariesDto> salariesDtoList = salaryMapper.toDtoList(salariesRepository.findAll());
        salariesDtoList.stream().map(x -> {
            Salaries salaries = new Salaries();
            salaries.setId(x.getId());
            salaries.setSalary(x.getSalary() + sum);
            salaries.setEnd_date(x.getStart_date());
            salaries.setStart_date(x.getStart_date());
            salaries.setEmployees(x.getEmployees());
            salaries = salariesRepository.save(salaries);
            return salaries;
        }).collect(Collectors.toList());
        return salariesDtoList;
    }


}
