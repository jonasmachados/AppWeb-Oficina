package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Carro;
import com.Jonas.AppWebOficina.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author Jonas, created 06/03/2021
 */
@RestController
@RequestMapping(value = "/carros")
public class CarroResource {
    
    @Autowired
    private CarroService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Integer id){
        Carro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
        
    }
}
