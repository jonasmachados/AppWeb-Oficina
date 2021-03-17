package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Mecanico;
import com.Jonas.AppWebOficina.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonas, created 17/03/2021
 */
@RestController
@RequestMapping(value = "/mecanicos")
public class MecanicoResource {

    @Autowired
    private MecanicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mecanico> findById(@PathVariable Integer id) {
        Mecanico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

}
