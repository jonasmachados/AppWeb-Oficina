package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Pecas;
import com.Jonas.AppWebOficina.dtos.PecasDTO;
import com.Jonas.AppWebOficina.service.PecaService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pecas> update(@PathVariable Integer id, @Valid @RequestBody Pecas obj) {
        Pecas newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Pecas> create(@Valid @RequestBody Pecas obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
