package com.ats.eCommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ats.eCommerce.model.Utente;
import com.ats.eCommerce.util.OracleDB;




public class UtenteDaoImpl implements UtenteDao, DaoConstant {

	
	private  Connection connection;

	public UtenteDaoImpl(){
		connection=OracleDB.getConnection();
	}

	@Override
	public boolean create(Utente utente) {
		
		String query =INSERT_UTENTE;
		PreparedStatement st= null;
		try {
			st= connection.prepareStatement(query);
			st.setInt(1,utente.getId());
			st.setString(2,utente.getNome());
			st.setString(3,utente.getCognome());
			st.setString(4,utente.getEmail());
			st.setDate(5, new java.sql.Date(utente.getData().getTime()));
			st.setString(6,utente.getUsername());
			st.setString(7,utente.getPassword());
			st.executeUpdate();
			System.out.println("Utente Aggiunto!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{try {
			if(st != null)
				st.close();
			} catch (Exception e2) {
			// TODO: handle exception
			}
		}

	}

	@Override
	public Utente read(int id) {
		Utente utente = new Utente();
		String query= READ_UTENTE;
		PreparedStatement st=null;
		ResultSet rs=null;

			try {
				st=connection.prepareStatement(query);
				st.setInt(1, id);
				rs=st.executeQuery();
				
				if(rs.next()){
					utente.setId(id);
					utente.setNome(rs.getString("nome"));
					utente.setCognome(rs.getString("cognome"));
					utente.setEmail(rs.getString("email"));
					utente.setData(rs.getDate("data"));
					utente.setUsername(rs.getString("username"));
					utente.setPassword(rs.getString("password"));
					System.out.println("Utente Letto!");
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{
				try {if(rs != null)
					rs.close();
					if(st != null)
						st.close();
					} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		
			return utente;
	}

	@Override
	public boolean update(Utente utente) {
		PreparedStatement st= null;
		String query=UPDATE_UTENTE;
		
		try {
			st=connection.prepareStatement(query);
			st.setInt(1,utente.getId());
			st.setString(2,utente.getNome());
			st.setString(3,utente.getCognome());
			st.setString(4,utente.getEmail());
			st.setDate(5, new java.sql.Date(utente.getData().getTime()));
			st.setString(6,utente.getUsername());
			st.setString(7,utente.getPassword());
			st.setInt(8,utente.getId());
			st.executeQuery();
			System.out.println("Utente Modificato!");
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		finally{try {
				if(st != null)
					st.close();
				} catch (Exception e2) {
				// TODO: handle exception
				}
		}
		}
	
		
	@Override
	public boolean delete(int id) {
		PreparedStatement st= null;
		String query=DELETE_UTENTE;
		try {
			st=connection.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();
			System.out.println("Utente Cancellato!");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			try {
				if(st != null)
					st.close();
				} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public Set<Utente> readAll() {
		Set<Utente> set = new LinkedHashSet<>();
		String query =READALL_UTENTE;
		
		PreparedStatement st=null;
		ResultSet rs =null;
		
		try {
			st=connection.prepareStatement(query);
			rs=st.executeQuery();
			while(rs.next()){
				
			
				Utente utente=new Utente();
				utente.setId(rs.getInt(1));
				utente.setNome(rs.getString(2));
				utente.setCognome(rs.getString(3));
				utente.setEmail(rs.getString(4));
				utente.setData(rs.getDate(5));
				utente.setUsername(rs.getString(6));
				utente.setPassword(rs.getString(7));
				
				set.add(utente);
				System.out.println("Utenti Letti!");
			}
			
		} catch (SQLException e) {
			return null;
		}finally{
			try {if(rs != null)
				rs.close();
				if(st != null)
					st.close();
				} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return set;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
}