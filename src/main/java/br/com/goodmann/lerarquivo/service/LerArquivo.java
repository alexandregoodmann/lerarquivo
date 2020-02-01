package br.com.goodmann.lerarquivo.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.lerarquivo.model.Cliente;
import br.com.goodmann.lerarquivo.model.ItemVenda;
import br.com.goodmann.lerarquivo.model.Resumo;
import br.com.goodmann.lerarquivo.model.Tipo;
import br.com.goodmann.lerarquivo.model.Venda;
import br.com.goodmann.lerarquivo.model.Vendedor;

@Component
public class LerArquivo {

	// @Value("${separador.linha}")
	private String separador = "#";
	private List<Cliente> clientes;
	private List<Vendedor> vendedores;
	private List<Venda> vendas;

	private ObjectMapper mapper = new ObjectMapper();

	public void lerArquivo() throws JsonProcessingException, IOException {

		// Usados para escrever o arquivo de resumo
		clientes = new ArrayList<Cliente>();
		vendedores = new ArrayList<Vendedor>();
		vendas = new ArrayList<Venda>();

		// pega o arquivo
		String dir = System.getProperty("user.dir");
		File file = new File(dir + "/data/in/arquivo.txt");

		// faz leitura das linhas
		LineIterator it = FileUtils.lineIterator(file, "UTF-8");
		try {
			while (it.hasNext()) {
				String linha = it.nextLine();
				this.parseLinha2Object(linha);
			}
		} finally {
			it.close();
		}

		this.escreverArquivo();
	}

	private void escreverArquivo() throws JsonProcessingException, IOException {

		// cria obj resumo
		Resumo resumo = new Resumo();
		resumo.setQtdClienteEntrada(this.clientes.size());
		resumo.setQtdVendedoresEntrada(this.vendedores.size());

		//Primeiro e último objeto da lista são: pior vendedor e venda mais cara.
		Collections.sort(vendas);
		resumo.setPiorVendedor(vendas.get(0).getName());
		resumo.setIdVendaMaisCara(vendas.get(vendas.size() - 1).getSaleID());

		// convert para json e salva
		String dir = System.getProperty("user.dir");
		String nome = "out_arquivo.txt";
		File file = new File(dir + "/data/out/" + nome);

		FileUtils.write(file, mapper.writeValueAsString(resumo), "UTF-8");

	}

	private void parseLinha2Object(String linha) {

		String[] vetLinha = linha.split(separador);
		Tipo tipo = Tipo.get(vetLinha[0]);

		switch (tipo) {
		case VENDEDOR:
			BigDecimal salario = new BigDecimal(vetLinha[3]);
			Vendedor vendedor = new Vendedor(vetLinha[1], vetLinha[2], salario);
			vendedores.add(vendedor);
			break;

		case CLIENTE:
			Cliente cliente = new Cliente(vetLinha[1], vetLinha[2], vetLinha[3]);
			clientes.add(cliente);
			break;

		case VENDA:
			Venda venda = this.parseVenda(vetLinha);
			vendas.add(venda);
			break;

		default:
			break;
		}
	}

	private Venda parseVenda(String[] vetLinha) {

		Venda venda = new Venda();
		venda.setSaleID(Integer.parseInt(vetLinha[1]));
		venda.setName(vetLinha[3]);

		// itens da venda
		String[] vetItem = vetLinha[2].replace("[", "").replace("]", "").split(",");

		// propriedades ItemVenda
		for (String i : vetItem) {

			String[] vetPropriedade = i.split("-");

			ItemVenda item = new ItemVenda();
			item.setIdItem(Integer.parseInt(vetPropriedade[0]));
			item.setQtd(Double.parseDouble(vetPropriedade[1]));
			item.setPrice(new BigDecimal(vetPropriedade[2]));

			BigDecimal totalItem = item.getPrice().multiply(BigDecimal.valueOf(item.getQtd()));
			venda.setValorTotal(venda.getValorTotal().add(totalItem));
			venda.getItens().add(item);
		}

		return venda;
	}

}
