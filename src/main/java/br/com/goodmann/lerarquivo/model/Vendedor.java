package br.com.goodmann.lerarquivo.model;

import java.math.BigDecimal;

public class Vendedor extends BaseModel {

	public Vendedor(String cpf, String name, BigDecimal salario) {
		super.setTipo(Tipo.VENDEDOR);
		super.setName(name);
		this.cpf = cpf;
		this.salario = salario;
	}

	private String cpf;

	private BigDecimal salario;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}
