package com.ats.eCommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ats.eCommerce.model.Prodotto;
import com.ats.eCommerce.util.OracleDB;

public class ProdottoDaoImpl implements ProdottoDao, DaoConstant {

		private Connection connection; 


		public ProdottoDaoImpl() {
			connection = OracleDB.getConnection();
		}
		@Override
		public boolean create(Prodotto prodotto) {
			PreparedStatement st= null;
			String query = INSERT_PRODOTTO;
			try {
				st=connection.prepareStatement(query);
				st.setInt(1, prodotto.getId());
				st.setString(2, prodotto.getCategoria());
				st.setString(3, prodotto.getTipo());
				st.setString(4, prodotto.getProdotto());
				st.setFloat(5, prodotto.getImportoSingolo());
				st.setInt(6, prodotto.getDisponibilita());
				st.executeUpdate();
				System.out.println("Prodotto aggiunto");
				return true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}


		}

		@Override
		public Prodotto read(int id) {
			// TODO Auto-generated method stub
			Prodotto prodotto = new Prodotto();
			
			String query = READ_PRODOTTO;
			
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement(query);
		st.setInt(1, id);
		
		rs=st.executeQuery();
		if(rs.next()) {
			prodotto.setId(id);
			prodotto.setCategoria(rs.getString("categoria"));
			prodotto.setTipo(rs.getString("tipo"));
			prodotto.setProdotto(rs.getString("prodotto"));
		prodotto.setImportoSingolo(rs.getFloat("importoSingolo"));
		prodotto.setDisponibilita(rs.getInt("disponibilita"));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return null;
		} finally {
			
				try {if(rs != null)
					rs.close();
				if(st != null)
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return prodotto;
		}

		@Override
		public boolean update(Prodotto prodotto) {
			PreparedStatement st= null;
			String query = UPDATE_PRODOTTO;
			try {
				st = connection.prepareStatement(query);
				st.setInt(1, prodotto.getId());
				st.setString(2, prodotto.getCategoria());
				st.setString(3, prodotto.getTipo());
				st.setString(4, prodotto.getProdotto());
				st.setFloat(5, prodotto.getImportoSingolo());
				st.setInt(6, prodotto.getDisponibilita());
				
				st.executeQuery();
				System.out.println("Prodotto modificato");
				return true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			return false;
		}

		@Override
		public boolean delete(int id) {
			PreparedStatement st= null;
			String query = DELETE_PRODOTTO;	
			try {
				st = connection.prepareStatement(query);
				st.setInt(1, id);
				System.out.println("Prodotto cancellato");
				st.executeQuery();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return false;
		}

		@Override
		public Set<Prodotto> readAll() {
			Set<Prodotto> set = new LinkedHashSet<>();
			
			String query = READALL_PRODOTTO;
			
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				st = connection.prepareStatement(query);
			
			rs = st.executeQuery();
			while(rs.next()) {
				Prodotto prodotto = new Prodotto();
				prodotto.setId(rs.getInt(1));
				prodotto.setCategoria(rs.getString(2));
				prodotto.setTipo(rs.getString(3));
				prodotto.setProdotto(rs.getString(4));
				prodotto.setImportoSingolo(rs.getFloat(5));
				prodotto.setDisponibilita(rs.getInt(6));
				
				
				set.add(prodotto);
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			return null;
			} finally {
				
					try {if(rs != null)
						rs.close();
					if(st != null)
						st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			return set;
			}

		@Override
		public void close() {
			// TODO Auto-generated method stub
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
