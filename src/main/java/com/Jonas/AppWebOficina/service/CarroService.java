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

    public Carro update(Integer id, Carro obj) {
        Carro newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Carro newObj, Carro obj) {
        newObj.setModelo(obj.getModelo());
        newObj.setMarca(obj.getMarca());
        newObj.setAno(obj.getAno());
        newObj.setChassi(obj.getChassi());
        newObj.setRenavan(obj.getRenavan());
        newObj.setCor(obj.getCor());
        newObj.setCombustivel(obj.getCombustivel());
    }

    public Carro create(Carro obj) {
        return repository.save(obj);
    }

}
