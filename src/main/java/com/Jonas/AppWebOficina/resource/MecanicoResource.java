package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Mecanico;
import com.Jonas.AppWebOficina.dtos.MecanicoDTO;
import com.Jonas.AppWebOficina.service.MecanicoService;
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

    @PostMapping
    public ResponseEntity<Mecanico> create(@RequestBody Mecanico obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Mecanico> update(@PathVariable Integer id, @Valid @RequestBody Mecanico obj){
        Mecanico newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
}
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
