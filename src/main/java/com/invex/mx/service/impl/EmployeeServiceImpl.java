package com.invex.mx.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.invex.mx.model.dto.EmployeeDto;
import com.invex.mx.model.dto.PagableInvexEmployee;
import com.invex.mx.model.entity.Employee;
import com.invex.mx.repository.EmployeeRepository;
import com.invex.mx.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public PagableInvexEmployee getAll(Integer page, Integer size, String sortBy) {
    	Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    	PagableInvexEmployee employeeInvex = new PagableInvexEmployee();
    	
    	Page<EmployeeDto> Employee =repository.findAll(pageable).map(this::toDto); 
    	employeeInvex.setEmployeeInvex(Employee.getContent());
    	employeeInvex.setSize(Employee.getNumber());
    	employeeInvex.setTotalpages(employeeInvex.getTotalpages());
    	
        return employeeInvex;
    }


    @Override
    public EmployeeDto getById(Long id) {
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public EmployeeDto create(EmployeeDto dto) {
        Employee employee =null;// toEntity(dto);
        return toDto(repository.save(employee));
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto dto) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

//        employee.setFirstName(dto.getFirstName());
//        employee.setMiddleName(dto.getMiddleName());
//        employee.setLastName(dto.getLastName());
//        employee.setSecondLastName(dto.getSecondLastName());
//        employee.setAge(dto.getAge());
//        employee.setGender(dto.getGender());
//        employee.setBirthDate(dto.getBirthDate());
//        employee.setJobTitle(dto.getJobTitle());
//        employee.setSystemEntryDate(dto.getSystemEntryDate());
//        employee.setActiveStatus(dto.getActiveStatus());

        return toDto(repository.save(employee));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Métodos auxiliares
    private EmployeeDto toDto(Employee e) {
        return new EmployeeDto(
                e.getEmployeeId(),
                e.getFirstName(),
                e.getMiddleName(),
                e.getLastName(),
                e.getSecondLastName(),
                e.getAge(),
                e.getGender(),
                e.getBirthDate(),
                e.getJobTitle(),
                e.getSystemEntryDate(),
                e.getActiveStatus()
        );
    }

//    private Employee toEntity(EmployeeDto dto) {
//        return new Employee(
//                dto.getEmployeeId(),
//                dto.getFirstName(),
//                dto.getMiddleName(),
//                dto.getLastName(),
//                dto.getSecondLastName(),
//                dto.getAge(),
//                dto.getGender(),
//                dto.getBirthDate(),
//                dto.getJobTitle(),
//                dto.getSystemEntryDate(),
//                dto.getActiveStatus()
//        );
//    }
    }