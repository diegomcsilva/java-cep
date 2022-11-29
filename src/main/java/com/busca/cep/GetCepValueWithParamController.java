package com.busca.cep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busca.cep.modelos.cepModel;

@RestController
public class GetCepValueWithParamController {
  // https://sematext.com/blog/slf4j-tutorial/
  private static Logger LOGGER = LoggerFactory.getLogger(GetCepValueWithParamController.class);

  @RequestMapping("/{cep}/{value}")
  public String GetCepValue(@PathVariable("cep") long cep, @PathVariable("value") String value) throws IOException {
    // API: https://viacep.com.br/
    // REF: https://stackoverflow.com/questions/1485708/how-do-i-do-a-http-get-in-java

    String urlString = "http://viacep.com.br/ws/" + cep + "/json";
    URL url = new URL(urlString);
    URLConnection conn = url.openConnection();
    InputStream is = conn.getInputStream();

    // REF: https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(is));
            
    StringBuilder result = new StringBuilder();

    for (String line; (line = reader.readLine()) != null; ) {
        result.append(line);
    }

    JSONObject json = new JSONObject(result.toString());

    cepModel cepResult = new cepModel(json);

    LOGGER.info("Get a specific with cep=" + value);

    // TODO: Think other format
    switch(value) {
      case "uf":
        return "uf: " + cepResult.getUf();

      case "complemento":
        return "complemento: " + cepResult.getComplemento();

      case "ddd":
        return "ddd: " + cepResult.getDdd();

      case "logradouro":
        return "logradouro: " + cepResult.getLogradouro();

      case "bairro":
        return "bairro: " + cepResult.getBairro();

      case "localidade":
        return "localidade: " + cepResult.getLocalidade();
        
      case "cep":
        return "cep: " + cepResult.getCep();

      default:
        return "Informe um campo válido!";
    }
    
  }
}
