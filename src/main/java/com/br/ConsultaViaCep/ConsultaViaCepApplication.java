package com.br.ConsultaViaCep;

import com.br.ConsultaViaCep.Model.EnderecoModel;
import com.br.ConsultaViaCep.Service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaViaCepApplication {


    public static void main(String[] args) throws Exception {
		SpringApplication.run(ConsultaViaCepApplication.class, args);
//        ViaCepService viaCepService = new ViaCepService();


//        EnderecoModel endereco = viaCepService.getEndereco("06516001");
//        System.out.println(viaCepService.getEndereco("06516001"));
	}

}
