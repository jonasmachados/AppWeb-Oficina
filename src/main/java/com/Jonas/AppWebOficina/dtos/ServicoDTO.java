package com.Jonas.AppWebOficina.dtos;

import com.Jonas.AppWebOficina.domain.Servico;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jonas, created 02/03/2021
 */
public class ServicoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Descricao é requerido/ Description is required")
    @Length(min = 5, max = 40, message = "Descricao nao pode ser nullo/ Description dont can be null")
    private String descricao;

    private Double preco;
    private Date dataServico;
    private Double km;

    //CONSTRUCTOR
    public ServicoDTO() {
    }

    //CONSTRUCTOR
    public ServicoDTO(Servico obj) {
        this.id = obj.getId();
        this.descricao = obj.getDescricao();
        this.preco = obj.getPreco();
        this.dataServico = obj.getDataServico();
        this.km = obj.getKm();
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getDataServico() {
        return dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

}
