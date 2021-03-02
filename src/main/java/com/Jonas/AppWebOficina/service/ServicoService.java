package com.Jonas.AppWebOficina.service;

import com.Jonas.AppWebOficina.domain.Servico;
import com.Jonas.AppWebOficina.repositories.ServicoRepository;
import java.util.Optional;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas, created 28/02/2021
 */
@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico findById(Integer id) throws ObjectNotFoundException {
        Optional<Servico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));

    }
}
