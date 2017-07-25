package com.ats.eCommerce.dao;

import java.util.Set;

import com.ats.eCommerce.model.Ordine;

public interface OrdineDao {

	public boolean create(Ordine ordine);
	public Ordine read(int id);
	public boolean update (Ordine ordine);
	public boolean delete(int id);
	public Set<Ordine> readAll();
	
	public void close();
}
