package br.com.goodmann.lerarquivo.model;

public class Cliente extends BaseModel {
	
	public Cliente(String cnpj, String name, String businessArea) {
		super.setTipo(Tipo.CLIENTE);
		super.setName(name);
		this.cnpj = cnpj;
		this.businessArea = businessArea;
	}

	private String cnpj;

	private String businessArea;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

}
