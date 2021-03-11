package com.Jonas.AppWebOficina.service;

import com.Jonas.AppWebOficina.domain.Carro;
import com.Jonas.AppWebOficina.domain.Mecanico;
import com.Jonas.AppWebOficina.domain.Pecas;
import com.Jonas.AppWebOficina.domain.Servico;
import com.Jonas.AppWebOficina.repositories.CarroRepository;
import com.Jonas.AppWebOficina.repositories.MecanicoRepository;
import com.Jonas.AppWebOficina.repositories.PecaRepository;
import com.Jonas.AppWebOficina.repositories.ServicoRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonas, created 27/02/2021
 */

@Service
public class DBService {

    //Summon class Repository for add H2
    @Autowired
    private CarroRepository carroRepository;

    //Summon class Repository for add H2
    @Autowired
    private MecanicoRepository mecanicoRepository;

    //Summon class Repository for add H2
    @Autowired
    private PecaRepository pecaRepository;

    //Summon class Repository for add H2
    @Autowired
    private ServicoRepository servicoRepository;

    public void instanciaBaseDeDados()throws Exception {
        //Format of date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Carro c1 = new Carro(null, "Celta", "Chevrolet", 2004, "Renavan 11", "Chassi 22", "Prata", "Gasolina");

        Mecanico m1 = new Mecanico(null, "Grand Pneus", 111, "37520-000", "Avenida Joao Pinheiros", 1008, "Centro", "Poços de Caldas", 36631724, "Observacoes", sdf.parse("21/02/2021"));
        Mecanico m2 = new Mecanico(null, "CASA PRADO", 111, "37520-000", "MARECHAL DEODORO", 589, "Centro", "Poços de Caldas", 37145878, "Observacoes", sdf.parse("25/02/2021"));
        Pecas p1 = new Pecas(null, "Retrovisor", sdf.parse("21/02/2021"), 100.0);
        Pecas p2 = new Pecas(null, "Parachoque", sdf.parse("21/02/2021"), 250.0);

        Pecas p3 = new Pecas(null, "FUZIVEL", sdf.parse("25/02/2021"), 40.0);
        Pecas p4 = new Pecas(null, "BATERIA", sdf.parse("25/02/2021"), 125.0);

        Servico s1 = new Servico(null, "Troca retrovisor", 120.0, sdf.parse("23/02/2021"), 90000.0, m1, c1);
        Servico s2 = new Servico(null, "TROCA FUZIL", 40.0, sdf.parse("25/02/2021"), 90005.0, m2, c1);
        Servico s3 = new Servico(null, "TROCA BATERIA", 125.0, sdf.parse("23/02/2021"), 90005.0, m2, c1);

        s1.getPecas().addAll(Arrays.asList(p1, p2));

        this.carroRepository.saveAll(Arrays.asList(c1));
        this.mecanicoRepository.saveAll(Arrays.asList(m1, m2));
        this.pecaRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
        this.servicoRepository.saveAll(Arrays.asList(s1, s2, s3));
    }

}
