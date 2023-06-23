package com.br.ConsultaViaCep.Controller;

import com.br.ConsultaViaCep.Model.EnderecoModel;
import com.br.ConsultaViaCep.Service.ViaCepService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/consulta/{cepRecebidoViaParametroNaURL}")
    public EnderecoModel consultaDoCep(@PathVariable String cepRecebidoViaParametroNaURL) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String jsonString = objectMapper.writeValueAsString(viaCepService);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return viaCepService.executaConsultaNoSiteDosCorreios(cepRecebidoViaParametroNaURL);
    }
}