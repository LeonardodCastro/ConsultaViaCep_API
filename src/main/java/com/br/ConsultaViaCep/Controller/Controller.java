package com.br.ConsultaViaCep.Controller;

import com.br.ConsultaViaCep.Model.EnderecoModel;
import com.br.ConsultaViaCep.Service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class Controller {

    @Autowired
    private ViaCepService viaCepService;

    File htmlFile = new File("");

    @GetMapping("/consulta/{cep}")
    public EnderecoModel consultaDoCep(@PathVariable String cep) {
        EnderecoModel endereco = new EnderecoModel();
        return viaCepService.executaConsultaNoSiteDosCorreios(cep);


    }
}