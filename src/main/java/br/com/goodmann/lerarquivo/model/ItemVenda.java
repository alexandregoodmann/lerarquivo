package br.com.goodmann.lerarquivo.model;

import java.math.BigDecimal;

public class ItemVenda {

	private Integer idItem;
	private Double qtd;
	private BigDecimal price;

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Double getQtd() {
		return qtd;
	}

	public void setQtd(Double qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}