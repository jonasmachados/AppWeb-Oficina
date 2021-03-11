package com.Jonas.AppWebOficina.config;

import com.Jonas.AppWebOficina.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Jonas, created 27/02/2021
 */
@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    //Method that will go make dependency injection
    @Bean
    public void instanciaBaseDeDados() throws Exception{
        this.dbService.instanciaBaseDeDados();
    }

}
