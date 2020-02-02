package br.com.goodmann.lerarquivo.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.goodmann.lerarquivo.model.Arquivo;

public class ArquivoProcessor implements ItemProcessor<Arquivo, Arquivo> {

	@Override
	public Arquivo process(Arquivo item) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("tá rolando?");
		return null;
	}

}
