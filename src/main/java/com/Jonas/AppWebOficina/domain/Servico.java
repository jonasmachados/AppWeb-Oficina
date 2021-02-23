package com.Jonas.AppWebOficina.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Jonas, created 22/02/2021
 */
@Entity
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Long preco;
    private Date dataServico;
    private Long km;
    
    @ManyToOne //Anotacao para associacao
    @JoinColumn(name = "mecanicoId")
    private Mecanico mecanico;
    
    @ManyToOne //Anotacao para associacao
    @JoinColumn(name = "carroId")
    private Carro carro;
    
    @OneToMany(mappedBy = "pecas") //Anotacao para associacao
    private List<Pecas> pecas = new ArrayList<>();

    //CONSTRUCTOR
    public Servico() {
    }

    //CONSTRUCTOR
    public Servico(Integer id, String descricao, Long preco, Date dataServico, Long km, Mecanico mecanico, Carro carro) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.dataServico = dataServico;
        this.km = km;
        this.mecanico = mecanico;
        this.carro = carro;
    }
    
    //EQUALS AND HASHCODE
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Servico other = (Servico) obj;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Pecas> getPecas() {
        return pecas;
    }

    public void setPecas(List<Pecas> pecas) {
        this.pecas = pecas;
    }
    
}
