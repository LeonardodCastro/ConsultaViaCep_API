package com.br.ConsultaViaCep.Controller;

import com.br.ConsultaViaCep.Controller.modelo.ObjetoQueVemDosCorreios;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class ChamaCorreiosController {

    @GetMapping("/consulta/{cep}")
    public String consultaDoCep(@PathVariable String cep) {
        ObjetoQueVemDosCorreios objetoQueVemDosCorreios = consultarNaBaseDosCorreiosUmCepInformado(cep);
        return objetoQueVemDosCorreios.toString();
    }

    private ObjetoQueVemDosCorreios consultarNaBaseDosCorreiosUmCepInformado(String cep) {
        String retornoDoSiteDosCorreios = irNoEndPointDosCorreiosETrazerAConsulta(cep);
        ObjetoQueVemDosCorreios vemDosCorreios = transformarAStringQueVeioEmUmObjetoQueQueremos(retornoDoSiteDosCorreios,cep);
        return vemDosCorreios;
    }

    private ObjetoQueVemDosCorreios transformarAStringQueVeioEmUmObjetoQueQueremos(String retornoDoSiteDosCorreios, String cepOriginal) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjetoQueVemDosCorreios dosCorreios = null;
        ObjetoQueVemDosCorreios esseCaraNaoExiste = null;
        try {
            dosCorreios = objectMapper.readValue(retornoDoSiteDosCorreios, ObjetoQueVemDosCorreios.class);
            return dosCorreios;
        } catch (Exception e) {
            return esseCaraNaoExiste;
        }
    }

    private String irNoEndPointDosCorreiosETrazerAConsulta(String cep) {
        String endPoint = "https://viacep.com.br/ws/" + cep + "/json/";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(endPoint))
                .build();
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
        }
        return httpResponse.body();
    }

}