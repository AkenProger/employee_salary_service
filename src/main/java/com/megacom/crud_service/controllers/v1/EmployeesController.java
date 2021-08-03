package com.megacom.crud_service.controllers.v1;

import com.megacom.crud_service.controllers.BaseController;
import com.megacom.crud_service.models.dto.EmployeesDto;
import com.megacom.crud_service.service.EmployeesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/employees")
@Api(value = "API для работы с сотрудниками")
public class EmployeesController implements BaseController<EmployeesDto, Long> {

    @Autowired
    EmployeesService employeesService;

    @Override
    public EmployeesDto save(EmployeesDto employeesDto) {
        return employeesService.save(employeesDto);
    }

    @Override
    public EmployeesDto update(EmployeesDto employeesDto) {
        return employeesService.update(employeesDto);
    }

    @Override
    public List<EmployeesDto> findAll() {
        return employeesService.findAll();
    }

    @Override
    public EmployeesDto findById(Long id) {
        return employeesService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        employeesService.deleteById(id);
    }


}
