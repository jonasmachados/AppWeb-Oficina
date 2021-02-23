package com.Jonas.AppWebOficina.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Jonas, created 23/02/2021
 */
@Entity
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    private String marca;
    private Integer ano;
    private Long chassi;
    private Long Renavan;
    private String cor;
    private String combustivel;

    @OneToMany(mappedBy = "carro") //Anotacao para associacao
    private List<Servico> servicos = new ArrayList<>();

    //CONSTRUCTOR
    public Carro() {
    }

    //CONSTRUCTOR
    public Carro(Integer id, String modelo, String marca, Integer ano, Long chassi, Long Renavan, String cor, String combustivel) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.chassi = chassi;
        this.Renavan = Renavan;
        this.cor = cor;
        this.combustivel = combustivel;
    }

    //EQUALS AND HASHCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Carro other = (Carro) obj;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Long getChassi() {
        return chassi;
    }

    public void setChassi(Long chassi) {
        this.chassi = chassi;
    }

    public Long getRenavan() {
        return Renavan;
    }

    public void setRenavan(Long Renavan) {
        this.Renavan = Renavan;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

}
