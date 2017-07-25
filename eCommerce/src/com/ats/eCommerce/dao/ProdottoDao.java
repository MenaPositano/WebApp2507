package com.ats.eCommerce.dao;

import java.util.Set;

import com.ats.eCommerce.model.Prodotto;

public interface ProdottoDao {
	
	public boolean create(Prodotto prodotto);
	public Prodotto read(int id);
	public boolean update (Prodotto prodotto);
	public boolean delete(int id);
	public Set<Prodotto> readAll();
	
	public void close();

}
