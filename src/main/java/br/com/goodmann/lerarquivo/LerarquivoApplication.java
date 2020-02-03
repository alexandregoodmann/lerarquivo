package br.com.goodmann.lerarquivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.goodmann.lerarquivo.service.DiretorioRunnable;

@SpringBootApplication
public class LerarquivoApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(LerarquivoApplication.class, args);
		new Thread(new DiretorioRunnable()).start();
	}

}
