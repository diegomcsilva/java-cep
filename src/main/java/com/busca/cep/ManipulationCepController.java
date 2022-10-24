package com.busca.cep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    String newLine = System.getProperty("line.separator");

    BufferedReader reader = new BufferedReader(
            new InputStreamReader(is));
    StringBuilder result = new StringBuilder();

    // TODO: Mapear o Json para retorno
    for (String line; (line = reader.readLine()) != null; ) {
        if (result.length() > 0) {
            result.append(newLine);
        }

        result.append(line);
    }
    
    System.out.println("Get a specific with cep=" + cep);

    return result.toString();
  }


}
