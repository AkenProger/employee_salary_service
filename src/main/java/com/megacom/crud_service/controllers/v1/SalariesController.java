package com.megacom.crud_service.controllers.v1;

import com.megacom.crud_service.controllers.BaseController;
import com.megacom.crud_service.models.dto.SalariesDto;
import com.megacom.crud_service.models.entities.Salaries;
import com.megacom.crud_service.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/salary")
public class SalariesController implements BaseController<SalariesDto, Long> {

    @Autowired
    SalaryService salaryService;

    @Override
    public SalariesDto save(SalariesDto salariesDto) {
        return salaryService.save(salariesDto);
    }

    @Override
    public SalariesDto update(SalariesDto salariesDto) {
        return salaryService.update(salariesDto);
    }

    @Override
    public List<SalariesDto> findAll() {
        return salaryService.findAll();
    }

    @Override
    public SalariesDto findById(Long id) {
        return salaryService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        salaryService.deleteById(id);
    }

    @GetMapping("/setSalary/{present},{sum}")
    public List<SalariesDto> setSalaryWhereMinSum(@PathVariable double present, @PathVariable double sum) {
        return salaryService.setSalaryWhereLittleSum(present, sum);
    }

    @GetMapping("/setPremium/{sum}")
    private List<SalariesDto> setPremium(@PathVariable double sum) {
        return salaryService.setPremium(sum);
    }




}
