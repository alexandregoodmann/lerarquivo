package br.com.goodmann.lerarquivo.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.goodmann.lerarquivo.model.Cliente;
import br.com.goodmann.lerarquivo.model.ItemVenda;
import br.com.goodmann.lerarquivo.model.Resumo;
import br.com.goodmann.lerarquivo.model.Tipo;
import br.com.goodmann.lerarquivo.model.Venda;
import br.com.goodmann.lerarquivo.model.Vendedor;

public class LerArquivo extends Thread {

	private Resumo resumo;
	private File file;

	public LerArquivo(File file) {
		this.file = file;
	}

	public Resumo lerArquivo() throws JsonProcessingException, IOException {

		// faz leitura das linhas
		LineIterator it = FileUtils.lineIterator(file, "ISO-8859-1");
		this.resumo = new Resumo();
		try {
			while (it.hasNext()) {
				String linha = it.nextLine();
				this.parseLinha2Object(linha);
			}
		} finally {
			it.close();
		}

		this.criaResumo();

		return resumo;
	}

	private void parseLinha2Object(String linha) {

		//String[] vetLinha = linha.split("\u00E7");
		String[] vetLinha = linha.split("\\ç");
		Tipo tipo = Tipo.get(vetLinha[0]);

		switch (tipo) {
		case VENDEDOR:
			BigDecimal salario = new BigDecimal(vetLinha[3]);
			Vendedor vendedor = new Vendedor(vetLinha[1], vetLinha[2], salario);
			this.resumo.getVendedores().add(vendedor);
			break;

		case CLIENTE:
			Cliente cliente = new Cliente(vetLinha[1], vetLinha[2], vetLinha[3]);
			this.resumo.getClientes().add(cliente);
			break;

		case VENDA:
			Venda venda = this.parseVenda(vetLinha);
			this.resumo.getVendas().add(venda);
			break;

		default:
			break;
		}
	}

	private void criaResumo() throws JsonProcessingException, IOException {

		// cria obj resumo
		resumo.setQtdClienteEntrada(resumo.getClientes().size());
		resumo.setQtdVendedoresEntrada(resumo.getVendedores().size());

		// Primeiro e último objeto da lista são: pior vendedor e venda mais cara.
		List<Venda> vendas = resumo.getVendas();
		if (vendas.size() > 0) {
			Collections.sort(vendas);
			resumo.setPiorVendedor(vendas.get(0).getName());
			resumo.setIdVendaMaisCara(vendas.get(vendas.size() - 1).getSaleID());
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

	public static void main(String[] args) {
		System.out.println("ç".getBytes());
	}
}
