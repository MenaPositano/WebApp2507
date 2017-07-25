package com.ats.eCommerce.model;

public class Prodotto {

	private int id;
	private String categoria;
	private String tipo;
	private String prodotto;
	private float importoSingolo;
	private int disponibilita;
	
	
	
	public Prodotto() {
	
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getProdotto() {
		return prodotto;
	}



	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}



	public float getImportoSingolo() {
		return importoSingolo;
	}



	public void setImportoSingolo(float importoSingolo) {
		this.importoSingolo = importoSingolo;
	}



	public int getDisponibilita() {
		return disponibilita;
	}



	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	
	
	
	
	
	
}
