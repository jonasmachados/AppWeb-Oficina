package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Servico;
import com.Jonas.AppWebOficina.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonas, created 28/02/2021
 */
@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Integer id) {
        Servico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
