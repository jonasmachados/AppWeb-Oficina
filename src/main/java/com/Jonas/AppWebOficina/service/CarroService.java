package com.Jonas.AppWebOficina.service;

import com.Jonas.AppWebOficina.domain.Carro;
import com.Jonas.AppWebOficina.domain.Servico;
import com.Jonas.AppWebOficina.repositories.CarroRepository;
import com.Jonas.AppWebOficina.service.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas, created 06/03/2021
 */
@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public Carro findById(Integer id) {
        Optional<Carro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));

    }

    public List<Carro> findAll() {
        return repository.findAll();
    }

}
