package br.com.goodmann.lerarquivo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.goodmann.lerarquivo.service.DiretorioRunnable;

@SpringBootTest
class LerarquivoApplicationTests {

	@Test
	void contextLoads() {
		DiretorioRunnable d = new DiretorioRunnable();
		d.run();
	}

}
