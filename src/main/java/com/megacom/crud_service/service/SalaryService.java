package com.megacom.crud_service.service;

import com.megacom.crud_service.models.dto.SalariesDto;

import java.util.List;

public interface SalaryService extends BaseCrudService<SalariesDto, Long> {

    List<SalariesDto> setSalaryWhereLittleSum(double percents, double sum);

    List<SalariesDto> setPremium(double sum);
}
