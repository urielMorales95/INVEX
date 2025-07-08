package com.invex.mx.service;

import java.util.List;

import com.invex.mx.model.dto.EmployeeDto;
import com.invex.mx.model.dto.PagableInvexEmployee;

public interface EmployeeService {

	PagableInvexEmployee getAll(Integer page, Integer size, String sortBy);

    EmployeeDto getById(Long id);

    EmployeeDto create(EmployeeDto dto);

    EmployeeDto update(Long id, EmployeeDto dto);

    void delete(Long id);
}
