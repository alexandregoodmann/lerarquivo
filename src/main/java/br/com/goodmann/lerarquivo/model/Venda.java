package br.com.goodmann.lerarquivo.model;

import java.util.List;

public class Venda extends BaseModel {

	private Integer saleID;

	private Double[] sale;

	private List<ItemVenda> itens;

	public Integer getSaleID() {
		return saleID;
	}

	public void setSaleID(Integer saleID) {
		this.saleID = saleID;
	}

	public Double[] getSale() {
		return sale;
	}

	public void setSale(Double[] sale) {
		this.sale = sale;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

}
