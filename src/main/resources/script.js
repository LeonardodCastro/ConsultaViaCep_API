function consultaCep() 
{
    let cep = document.getElementById('inlineFormInputGroupCep').value;

    if (cep.length < 8) 
    {
        alert('CEP INVÁLIDO');
        return
    } 

    let urlAPI = `https://viacep.com.br/ws/${cep}/json/`;

    fetch(urlAPI)
            .then(function(response){
                response.json().then(function(data){
                    console.log(data)
                    preencherEndereco(data, urlAPI)
                })
            })   
}

function preencherEndereco(dados, url)
{
    let texto = document.getElementById('retornoJson');
    texto.innerHTML = `<p>Bairro: ${dados.bairro}</p>
                       <p>Cep: ${dados.cep}</p>
                       <p>Complemento: ${dados.complemento}</p>
                       <p>DDD: ${dados.ddd}</p>
                       <p>Gia: ${dados.gia}</p>
                       <p>IBGE: ${dados.ibge}</p>
                       <p>Localidade: ${dados.localidade}</p>
                       <p>Logradouro: ${dados.logradouro}</p>
                       <p>Siafi: ${dados.siafi}</p>
                       <p>UF: ${dados.uf}</p>
                       
                       `
    let textUrl = document.getElementById('url');
    textUrl.innerText = url;
}



// `<p>Bairro: ${dados.bairro}</p>
//                         <p>Cep: ${dados.cep}</p>
//                         <p>Complemento: ${dados.complemento}</p>
//                         <p>DDD: ${dados.ddd}</p>
//                         <p>Gia: ${dados.gia}</p>
//                         <p>IBGE: ${dados.ibge}</p>
//                         <p>Localidade: ${dados.localidade}</p>
//                         <p>Logradouro: ${dados.logradouro}</p>
//                         <p>Siafi: ${dados.siafi}</p>
//                         <p>UF: ${dados.uf}</p>
//                         `