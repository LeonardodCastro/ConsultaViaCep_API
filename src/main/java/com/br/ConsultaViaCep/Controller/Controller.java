package com.br.ConsultaViaCep.Controller;

import com.br.ConsultaViaCep.Model.EnderecoModel;
import com.br.ConsultaViaCep.Service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    private ViaCepService viaCepService;


    @GetMapping("/consulta/{cepRecebidoViaParametroNaURL}")
    public EnderecoModel consultaDoCep(@PathVariable String cepRecebidoViaParametroNaURL){
        return viaCepService.executaConsultaNoSiteDosCorreios(cepRecebidoViaParametroNaURL);
    }
}
