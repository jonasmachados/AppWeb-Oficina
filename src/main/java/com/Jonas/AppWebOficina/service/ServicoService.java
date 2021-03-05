package com.Jonas.AppWebOficina.service;

import com.Jonas.AppWebOficina.domain.Servico;
import com.Jonas.AppWebOficina.dtos.ServicoDTO;
import com.Jonas.AppWebOficina.repositories.ServicoRepository;
import com.Jonas.AppWebOficina.service.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas, created 28/02/2021
 */
@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico findById(Integer id) {
        Optional<Servico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));
    }

    public List<Servico> findAll() {
        return repository.findAll();
    }

    public Servico create(Servico obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Servico update(Integer id, ServicoDTO objDto) {
        Servico obj = findById(id);
        obj.setDescricao(objDto.getDescricao());
        obj.setPreco(objDto.getPreco());
        obj.setDataServico(objDto.getDataServico());
        obj.setKm(objDto.getKm());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.Jonas.AppWebOficina.service.exceptions.DataIntegrityViolationException(
                    "Categoria não pode ser deletada! Possui livros associados");
        }

    }
}
