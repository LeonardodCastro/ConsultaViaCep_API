package com.br.ConsultaViaCep.Service;

import com.br.ConsultaViaCep.Model.EnderecoModel;
import com.google.gson.Gson;
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
        //TODO converter o objeto que esta chegando para o EnderecoModel (done)


        EnderecoModel endereco = new Gson().fromJson(httpResponse.body(), EnderecoModel.class);

//            var endereco1 = new EnderecoModel();
//        BeanUtils.copyProperties(httpResponse, enderecoModel);

        enderecoModel.setCep(endereco.getCep());
        enderecoModel.setLogradouro(endereco.getLogradouro());
        enderecoModel.setComlemento(endereco.getComlemento());
        enderecoModel.setBairro(endereco.getBairro());
        enderecoModel.setLocalidade(endereco.getLocalidade());
        enderecoModel.setUf(endereco.getUf());
        enderecoModel.setIbge(endereco.getIbge());
        enderecoModel.setGia(endereco.getGia());
        enderecoModel.setDdd(endereco.getDdd());
        enderecoModel.setSiafi(endereco.getSiafi());

        return enderecoModel;
//        return endereco1;
    }
}
