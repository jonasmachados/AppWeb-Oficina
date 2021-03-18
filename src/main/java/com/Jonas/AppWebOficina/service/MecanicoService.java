package com.Jonas.AppWebOficina.service;

import com.Jonas.AppWebOficina.domain.Mecanico;
import com.Jonas.AppWebOficina.repositories.MecanicoRepository;
import com.Jonas.AppWebOficina.service.exceptions.ObjectNotFoundException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;

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

    public Mecanico update(Integer id, Mecanico obj) {
        Mecanico newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Mecanico newObj, Mecanico obj) {
        newObj.setId(obj.getId());
        newObj.setRazaoSocial(obj.getRazaoSocial());
        newObj.setCpf_Cnpj(obj.getCpf_Cnpj());
        newObj.setCep(obj.getCep());
        newObj.setEndereco(obj.getEndereco());
        newObj.setBairro(obj.getBairro());
        newObj.setCidade(obj.getCidade());
        newObj.setTelefone(obj.getTelefone());
        newObj.setAdicionais(obj.getAdicionais());
        newObj.setDataCriacao(obj.getDataCriacao());
    }

}
