package com.busca.cep;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

	@GetMapping("/")
  @ResponseBody
	public String home() {
		return "<h2 align='center'>Informe um CEP na URL para que a busca seja feita!</h1>";
	}
}