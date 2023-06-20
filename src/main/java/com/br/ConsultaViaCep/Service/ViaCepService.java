package com.br.ConsultaViaCep.Service;

import com.br.ConsultaViaCep.Model.EnderecoModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ViaCepService {

    public EnderecoModel executaConsultaNoSiteDosCorreios(String cepQueSeraConsultado) {

        EnderecoModel enderecoModel = new EnderecoModel();

        String endPoint = "https://viacep.com.br/ws/" + cepQueSeraConsultado + "/json/";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(endPoint))
                .build();
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readValue(httpResponse.body(),EnderecoModel.class);
        } catch (JsonProcessingException e) {
            System.out.println("Deu erro aqui!");
        }
        return enderecoModel;
    }
}
