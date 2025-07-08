package com.invex.mx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    


    @GetMapping("/check-db")
    public String checkDBConnection() {
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1 FROM DUAL", Integer.class);
            return "Conexión exitosa a Oracle: Resultado = " + result;
        } catch (Exception e) {
            return "Error al conectar con la base de datos: " + e.getMessage();
        }
    }
 
    
    
}