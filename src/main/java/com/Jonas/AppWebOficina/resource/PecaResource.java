package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Pecas;
import com.Jonas.AppWebOficina.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonas, created 18/03/2021
 */
@RestController
@RequestMapping(value = "/pecas")
public class PecaResource {

    @Autowired
    private PecaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pecas> findById(@PathVariable Integer id) {
        Pecas obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
