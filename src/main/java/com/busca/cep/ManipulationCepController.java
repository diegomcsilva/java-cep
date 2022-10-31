package com.busca.cep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busca.cep.modelos.cepModel;

@RestController
public class ManipulationCepController {

  @RequestMapping("/{cep}")
  public String GetCep(@PathVariable("cep") long cep) throws IOException {
    // API: https://viacep.com.br/
    // REF: https://stackoverflow.com/questions/1485708/how-do-i-do-a-http-get-in-java

    // TODO: receber parametro na rota
    String urlString = "http://viacep.com.br/ws/" + cep + "/json";
    URL url = new URL(urlString);
    URLConnection conn = url.openConnection();
    InputStream is = conn.getInputStream();

    // REF: https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(is));
            
    StringBuilder result = new StringBuilder();

    // TODO: Mapear o Json para retorno

    for (String line; (line = reader.readLine()) != null; ) {
        result.append(line);
    }

    JSONObject json = new JSONObject(result.toString());

    // cepModel cepzinho = new cepModel(json.toString)

    // System.out.println("Get a specific with cep=" + cepzinho);

    return json.toString();
  }


}
