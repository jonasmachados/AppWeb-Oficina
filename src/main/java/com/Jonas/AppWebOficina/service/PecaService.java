package com.Jonas.AppWebOficina.service;

import com.Jonas.AppWebOficina.domain.Pecas;
import com.Jonas.AppWebOficina.repositories.PecaRepository;
import com.Jonas.AppWebOficina.service.exceptions.ObjectNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas, created 18/02/2021
 */
@Service
public class PecaService {

    @Autowired
    private PecaRepository repository;

    public Pecas findById(Integer id) {
        Optional<Pecas> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", Tipo: " + Pecas.class.getName()));
    }
}
