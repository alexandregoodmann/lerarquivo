package br.com.goodmann.lerarquivo.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.goodmann.lerarquivo.model.BaseModel;
import br.com.goodmann.lerarquivo.model.Cliente;
import br.com.goodmann.lerarquivo.model.Tipo;
import br.com.goodmann.lerarquivo.model.Vendedor;

@Component
public class LerArquivo {

	@Value("${separador}")
	private String separador;

	public List<String> linhas() throws IOException {
		String dir = System.getProperty("user.dir");
		File file = new File(dir + "/data/in/arquivo.txt");
		return FileUtils.readLines(file, "UTF-8");
	}

	public BaseModel parse2Obj(String linha) {

		// FIXME MELHORAR SEPARADOR
		BaseModel model = null;

		separador = "ç";
		String[] vet = linha.split(separador);
		Tipo tipo = Tipo.get(vet[0]);

		switch (tipo) {
		case VENDEDOR:
			BigDecimal salario = new BigDecimal(vet[3]);
			model = new Vendedor(vet[1], vet[2], salario);
			break;
		case CLIENTE:
			model = new Cliente(vet[1], vet[2], vet[3]);
			break;
		case VENDA:
			// model = new Venda(vet[1], vet[2], vet[3]);
			break;

		default:
			break;
		}

		return model;
	}

	private void parseVenda(String linha) {
		
		//linha de venda
		String[] vet = linha.split(separador);
		
		//itens da venda
		String[] vetItens = linha.split(","); 

	}

}
