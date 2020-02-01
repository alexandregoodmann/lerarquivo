package br.com.goodmann.lerarquivo;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.goodmann.lerarquivo.service.LerArquivo;

@SpringBootTest
class LerarquivoApplicationTests {

	@Autowired
	private LerArquivo ler;

	@Test
	void contextLoads() throws IOException {

		List<String> linhas = ler.linhas();
		linhas.forEach(d -> {
			System.out.println(ler.parse2Obj(d));
		});
	}

}
