package br.com.goodmann.lerarquivo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda extends BaseModel implements Comparable<Venda> {

	private Integer saleID;

	private BigDecimal valorTotal = BigDecimal.ZERO;

	private List<ItemVenda> itens = new ArrayList<ItemVenda>();

	public Integer getSaleID() {
		return saleID;
	}

	public void setSaleID(Integer saleID) {
		this.saleID = saleID;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public int compareTo(Venda o) {
		return this.valorTotal.compareTo(o.getValorTotal());
	}

}
