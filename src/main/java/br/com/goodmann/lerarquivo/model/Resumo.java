package br.com.goodmann.lerarquivo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Resumo {

	private Integer qtdClienteEntrada;
	private Integer qtdVendedoresEntrada;
	private Integer idVendaMaisCara;
	private String piorVendedor;

	@JsonIgnore
	private List<Vendedor> vendedores = new ArrayList<Vendedor>();

	@JsonIgnore
	private List<Cliente> clientes = new ArrayList<Cliente>();

	@JsonIgnore
	private List<Venda> vendas = new ArrayList<Venda>();

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

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

}
