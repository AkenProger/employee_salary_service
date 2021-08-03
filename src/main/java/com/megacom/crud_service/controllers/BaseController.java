package com.megacom.crud_service.controllers;

import jdk.dynalink.linker.LinkerServices;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import java.awt.*;

public interface BaseController<S, T>{
    @PostMapping("/save")
    S save(@RequestBody S s);

    @PutMapping("/update")
    S update(@RequestBody S s);

    @GetMapping("/all")
    List<S> findAll();

    @GetMapping("/{id}")
    S findById(@PathVariable T id);

    @GetMapping("/delete/{id}")
    void deleteById(@PathVariable T id);
}
