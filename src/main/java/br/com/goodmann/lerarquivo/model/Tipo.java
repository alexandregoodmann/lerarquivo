package br.com.goodmann.lerarquivo.model;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Tipo {

	VENDEDOR("001"), CLIENTE("002"), VENDA("003");

	private String tipo;

	private static final Map<String, Tipo> MAPA;

	Tipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}

	static {
		Map<String, Tipo> map = new ConcurrentHashMap<String, Tipo>();
		for (Tipo instance : Tipo.values()) {
			map.put(instance.getTipo(), instance);
		}
		MAPA = Collections.unmodifiableMap(map);
	}

	public static Tipo get(String name) {
		return MAPA.get(name);
	}

}
