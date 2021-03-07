package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Carro;
import com.Jonas.AppWebOficina.dtos.CarroDTO;
import com.Jonas.AppWebOficina.service.CarroService;
import java.util.List;
import java.util.stream.Collectors;
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
    
    @GetMapping
    public ResponseEntity<List<CarroDTO>> findALl(){
        List<Carro> list = service.findAll();
        List<CarroDTO> listDTO = list.stream().map(obj -> new CarroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    
}
