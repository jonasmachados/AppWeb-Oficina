package com.Jonas.AppWebOficina.service;

import com.Jonas.AppWebOficina.domain.Carro;
import com.Jonas.AppWebOficina.domain.Mecanico;
import com.Jonas.AppWebOficina.repositories.MecanicoRepository;
import com.Jonas.AppWebOficina.service.exceptions.DataIntegrityViolationException;
import com.Jonas.AppWebOficina.service.exceptions.ObjectNotFoundException;
import java.util.List;
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

    public List<Mecanico> findAll() {
        return repository.findAll();
    }

    public Mecanico create(Mecanico obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.Jonas.AppWebOficina.service.exceptions.DataIntegrityViolationException("Mecanico nao encontrado / Mechanic not found");
        }
    }

}
