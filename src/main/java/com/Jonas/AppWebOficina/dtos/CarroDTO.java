package com.Jonas.AppWebOficina.dtos;

import com.Jonas.AppWebOficina.domain.Carro;

/**
 *
 * @author Jonas, created 06/03/2021
 */
public class CarroDTO {

    private Integer id;
    private String modelo;
    private String marca;

    //CONSTRUCOTR
    public CarroDTO() {
    }

    //CONSTRUCTOR
    public CarroDTO(Carro obj) {
        this.id = obj.getId();
        this.modelo = obj.getModelo();
        this.marca = obj.getMarca();
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

}
