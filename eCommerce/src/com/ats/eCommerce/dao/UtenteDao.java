package com.ats.eCommerce.dao;

import java.util.Set;

import com.ats.eCommerce.model.Utente;

public interface UtenteDao {

	public boolean create(Utente utente);
	public Utente read(int id);
	public boolean update (Utente utente);
	public boolean delete(int id);
	public Set<Utente> readAll();
	
	public void close();
	
	
	
	
}
