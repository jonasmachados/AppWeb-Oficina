package com.Jonas.AppWebOficina.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Jonas, created 21/02/2021
 */

@Entity
public class Mecanico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String razaoSocial;
    private Integer cpf_Cnpj;
    private String cep;
    private String endereco;
    private Integer numero;
    private String bairro;
    private String cidade;
    private Integer telefone;
    private String adicionais;
    private Date dataCriacao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "mecanico") //Anotacao para associacao
    private List<Servico> servicos = new ArrayList<>();

    //CONSTRUCTOR
    public Mecanico() {
    }

    //CONSTRUCTOR
    public Mecanico(Integer id, String razaoSocial, Integer cpf_Cnpj, String cep, String endereco, Integer numero, String bairro, String cidade, Integer telefone, String adicionais, Date dataCriacao) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cpf_Cnpj = cpf_Cnpj;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.telefone = telefone;
        this.adicionais = adicionais;
        this.dataCriacao = dataCriacao;
    }
    
    //HASH CODE E EQUALS
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mecanico other = (Mecanico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
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

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
    
}
