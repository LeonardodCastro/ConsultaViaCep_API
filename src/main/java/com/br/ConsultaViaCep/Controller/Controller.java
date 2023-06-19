package com.br.ConsultaViaCep.Controller;

import com.br.ConsultaViaCep.Model.EnderecoModel;
import com.br.ConsultaViaCep.Service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    private ViaCepService viaCepService;


    @GetMapping("/consulta")
    public ViaCepService root(){
        EnderecoModel endereco = new EnderecoModel();
        endereco.setCep("06516001");
//        return endereco;
        return viaCepService;
    }
    public Controller(ViaCepService viaCepService) throws Exception {
        this.viaCepService = viaCepService;
    }
}
