package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Mecanico;
import com.Jonas.AppWebOficina.dtos.MecanicoDTO;
import com.Jonas.AppWebOficina.service.MecanicoService;
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

    @GetMapping
    public ResponseEntity<List<MecanicoDTO>> findAll() {
        List<Mecanico> list = service.findAll();
        List<MecanicoDTO> listDTO = list.stream().map(obj -> new MecanicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

}
