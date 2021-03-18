package com.Jonas.AppWebOficina.dtos;

import com.Jonas.AppWebOficina.domain.Mecanico;
import java.util.Date;

/**
 *
 * @author Jonas, created 17/03/2021
 */
public class MecanicoDTO {

    private Integer id;

    private String razaoSocial;
    private Integer cpf_Cnpj;
    private String cep;
    private String endereco;
    private Integer numero;
    private String bairro;
    private String cidade;
    private Integer telefone;

    //CONSTRUCTOR
    public MecanicoDTO() {
    }

    //CONSTRUCTOR
    public MecanicoDTO(Mecanico obj) {
        this.id = obj.getId();
        this.razaoSocial = obj.getRazaoSocial();
        this.cpf_Cnpj = obj.getCpf_Cnpj();
        this.cep = obj.getCep();
        this.endereco = obj.getEndereco();
        this.numero = obj.getNumero();
        this.bairro = obj.getBairro();
        this.cidade = obj.getCidade();
        this.telefone = obj.getTelefone();
    }

    //GET AND SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Integer getCpf_Cnpj() {
        return cpf_Cnpj;
    }

    public void setCpf_Cnpj(Integer cpf_Cnpj) {
        this.cpf_Cnpj = cpf_Cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

}
