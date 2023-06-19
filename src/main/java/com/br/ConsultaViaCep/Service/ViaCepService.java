package com.br.ConsultaViaCep.Service;
import com.br.ConsultaViaCep.Model.EnderecoModel;
import com.google.gson.Gson;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

@Service
public class ViaCepService {

    public ViaCepService()  {
        EnderecoModel enderecoModel = new EnderecoModel();
        try {
        URL url = new URL("https://viacep.com.br/ws/"+ enderecoModel.getCep()+"/json/");
        URLConnection connection = null;
            connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

        String cep = "";
        StringBuilder jsonCep = new StringBuilder();
        while ((cep = bufferedReader.readLine()) != null){
            jsonCep.append(cep);
        }
        System.out.println(jsonCep.toString());
        EnderecoModel endereco = new Gson().fromJson(jsonCep.toString(),EnderecoModel.class);

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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
