package br.com.goodmann.lerarquivo;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.lerarquivo.service.LerArquivo;

@SpringBootTest
class LerarquivoApplicationTests {

	@Autowired
	private LerArquivo ler;

	private ObjectMapper mapper = new ObjectMapper();

	@Test
	void contextLoads() throws IOException {
		ler.lerArquivo();
	}

}
