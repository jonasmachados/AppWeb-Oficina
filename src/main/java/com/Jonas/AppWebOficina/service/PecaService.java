package com.Jonas.AppWebOficina.service;

import com.Jonas.AppWebOficina.domain.Pecas;
import com.Jonas.AppWebOficina.repositories.PecaRepository;
import com.Jonas.AppWebOficina.service.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public List<Pecas> findAll() {
        return repository.findAll();
    }

    public Pecas update(Integer id, Pecas obj) {
        Pecas newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);

    }

    public void updateData(Pecas newObj, Pecas obj) {
        newObj.setDescricao(obj.getDescricao());
        newObj.setDataCompra(obj.getDataCompra());
        newObj.setPreco(obj.getPreco());
    }

    public Pecas create(Pecas obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.Jonas.AppWebOficina.service.exceptions.DataIntegrityViolationException("Objeto nao pode ser deletado! Possui objetos associados");
        }
    }
}
