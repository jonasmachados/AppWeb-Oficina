package com.Jonas.AppWebOficina.service;

import com.Jonas.AppWebOficina.domain.Mecanico;
import com.Jonas.AppWebOficina.repositories.MecanicoRepository;
import com.Jonas.AppWebOficina.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 *
 * @author Jonas, created 17/03/2021
 */
@Service
public class MecanicoService {

    @Autowired
    MecanicoRepository repository;

    public Mecanico findById(Integer id) {
        Optional<Mecanico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", Tipo: " + Mecanico.class.getName()));
    }

}
