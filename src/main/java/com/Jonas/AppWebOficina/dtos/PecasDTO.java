package com.Jonas.AppWebOficina.dtos;

import com.Jonas.AppWebOficina.domain.Pecas;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jonas, created 19/03/2021
 */
public class PecasDTO {

    private Integer id;

    @NotEmpty(message = "Descricao é requerido/ description is required")
    @Length(min = 5, max = 40, message = "Descricao nao pode ser nullo/ description dont can be null")
    private String Descricao;

    private Double preco;

    //CONSTRUCTOR
    public PecasDTO() {
    }

    //CONSTRUCTOR
    public PecasDTO(Pecas obj) {
        this.id = obj.getId();
        this.Descricao = obj.getDescricao();
        this.preco = obj.getPreco();
    }

    //GET AND SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
