package br.com.goodmann.lerarquivo.model;

public class Resumo {

	private Integer qtdClienteEntrada;
	private Integer qtdVendedoresEntrada;
	private Integer idVendaMaisCara;
	private String piorVendedor;

	public Integer getQtdClienteEntrada() {
		return qtdClienteEntrada;
	}

	public void setQtdClienteEntrada(Integer qtdClienteEntrada) {
		this.qtdClienteEntrada = qtdClienteEntrada;
	}

	public Integer getQtdVendedoresEntrada() {
		return qtdVendedoresEntrada;
	}

	public void setQtdVendedoresEntrada(Integer qtdVendedoresEntrada) {
		this.qtdVendedoresEntrada = qtdVendedoresEntrada;
	}

	public Integer getIdVendaMaisCara() {
		return idVendaMaisCara;
	}

	public void setIdVendaMaisCara(Integer idVendaMaisCara) {
		this.idVendaMaisCara = idVendaMaisCara;
	}

	public String getPiorVendedor() {
		return piorVendedor;
	}

	public void setPiorVendedor(String piorVendedor) {
		this.piorVendedor = piorVendedor;
	}

}
