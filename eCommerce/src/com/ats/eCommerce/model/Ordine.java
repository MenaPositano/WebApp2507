package com.ats.eCommerce.model;

public class Ordine {

	private int id;
	private int id_utente;
	private int id_indirizzo;
	private float importoTotale;
	
	
	public Ordine() {
	
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_utente() {
		return id_utente;
	}


	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}


	public int getId_indirizzo() {
		return id_indirizzo;
	}


	public void setId_indirizzo(int id_indirizzo) {
		this.id_indirizzo = id_indirizzo;
	}


	public float getImportoTotale() {
		return importoTotale;
	}


	public void setImportoTotale(float importoTotale) {
		this.importoTotale = importoTotale;
	}
	
	
	
	
	
	
	
}
