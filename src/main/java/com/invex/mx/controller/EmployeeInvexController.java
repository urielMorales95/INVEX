package com.invex.mx.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.invex.mx.model.dto.*;
import com.invex.mx.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeInvexController {
	
	
	@Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees(   @RequestParam(defaultValue = "0") int page,
            									@RequestParam(defaultValue = "10") int size,
            									@RequestParam(defaultValue = "employeeId") String sortBy) {
    	
    	ResponseBody response = new ResponseBody();
    	PagableInvexEmployee responseEmployeePageable = employeeService.getAll(page,size,sortBy);
    	
    	if(responseEmployeePageable.getEmployeeInvex()!= null && !responseEmployeePageable.getEmployeeInvex().isEmpty()) {
    		response.setCodigo(200);
            response.setMsg("Datos encontrados");
            response.setData(responseEmployeePageable);
            return new ResponseEntity<>(response, HttpStatus.OK);
    	}else {
    		response.setCodigo(0);
            response.setMsg("No se encontraron Datos");
            return new ResponseEntity<>(response, HttpStatus.OK);
    	}
    	
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto EmployeeDto) {
        return ResponseEntity.ok(employeeService.create(EmployeeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto dto) {
        return ResponseEntity.ok(employeeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

	    
}
