package com.megacom.crud_service.service;

import com.megacom.crud_service.models.dto.EmployeesDto;

import java.util.List;

public interface BaseCrudService<S, T> {
    S save(S s);

    S update(S s);

    List<S> findAll();

    S findById(T id);

    void deleteById(T id);


}
