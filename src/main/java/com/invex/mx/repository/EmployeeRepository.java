package com.invex.mx.repository;

import com.invex.mx.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Puedes agregar métodos personalizados aquí si los necesitas más adelante
}