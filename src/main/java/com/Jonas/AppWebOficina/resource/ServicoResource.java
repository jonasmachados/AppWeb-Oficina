package com.Jonas.AppWebOficina.resource;

import com.Jonas.AppWebOficina.domain.Servico;
import com.Jonas.AppWebOficina.dtos.ServicoDTO;
import com.Jonas.AppWebOficina.service.ServicoService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @author Jonas, created 28/02/2021
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Integer id){
        Servico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> findAll() {
        List<Servico> list = service.findAll();
        List<ServicoDTO> listDTO = list.stream().map(obj -> new ServicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Servico> create(@Valid @RequestBody Servico obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ServicoDTO> update(@Valid @PathVariable Integer id, @RequestBody ServicoDTO objDto) {
        Servico newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new ServicoDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
