package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Pecas;
import com.Jonas.AppWebOficina.dtos.PecasDTO;
import com.Jonas.AppWebOficina.service.PecaService;
import java.util.List;
import java.util.stream.Collectors;
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

    @GetMapping
    public ResponseEntity<List<PecasDTO>> findAll() {
        List<Pecas> list = service.findAll();
        List<PecasDTO> listDTO = list.stream().map(obj -> new PecasDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

}
