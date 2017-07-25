package com.ats.eCommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ats.eCommerce.model.Ordine;
import com.ats.eCommerce.model.Utente;
import com.ats.eCommerce.util.OracleDB;

public class OrdineDaoImpl implements OrdineDao, DaoConstant {
   private Connection connection;
 
   
   public OrdineDaoImpl() {
		connection=OracleDB.getConnection();

         }

	@Override
	public boolean create(Ordine ordine) {
		
		PreparedStatement st= null;
		
		try {
			st=connection.prepareStatement(INSERT_ORDINE);
			st.setInt(1, ordine.getId());
			st.setInt(2, ordine.getId_utente());
			st.setInt(3, ordine.getId_indirizzo());
			st.setFloat(4, ordine.getImportoTotale());
			st.executeUpdate();
			System.out.println("Ordine aggiunto");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(st != null)
				st.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		return true;
	}
	
	@Override
	public Ordine read(int id) {
		
			
			Ordine ordine=new Ordine();
			
			PreparedStatement st= null;
			ResultSet rs= null;
			try {
				st=connection.prepareStatement(READ_ORDINE);
				st.setInt(1,id);
				rs=st.executeQuery();
				if(rs.next()){
					ordine.setId(id);
					ordine.setId_utente(rs.getInt("id_utente")); 
					ordine.setId_indirizzo(rs.getInt("id_indirizzo")); 
					ordine.setImportoTotale(rs.getFloat("importototale"));;
			
					System.out.println("Ordine letto!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs != null)
					rs.close();
					if(st != null)
					st.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
				
			}
			
			
			return ordine;
	}
	

	@Override
	public boolean update(Ordine ordine){
		PreparedStatement st= null;
		try {
			st=connection.prepareStatement(UPDATE_INDIRIZZO);
			st.setInt(1, ordine.getId());
			st.setInt(2, ordine.getId_utente());
			st.setInt(3, ordine.getId_indirizzo());
			st.setFloat(4, ordine.getImportoTotale());
			st.executeUpdate();
			System.out.println("Utente Modificato!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(st != null)
				st.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		return true;
	}

	
	@Override
	public boolean delete(int id)  {
		PreparedStatement st= null;
		try {
			st= connection.prepareStatement(DELETE_ORDINE);
			st.setInt(1, id);
			st.executeQuery();
			System.out.println("Ordine cancellato!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(st != null)
				st.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		return true;
	}
	

	@Override
	public Set<Ordine> readAll() {
		
		Set<Ordine> set=new LinkedHashSet<Ordine>();
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			st=connection.prepareStatement(READALL_ORDINE);
			rs=st.executeQuery();
			while(rs.next()){
				Ordine ordine=new Ordine();
				ordine.setId(rs.getInt(1));
				ordine.setId_utente(rs.getInt(2));
				ordine.setId_indirizzo(rs.getInt(3));
				ordine.setImportoTotale(rs.getFloat(4));
			    set.add(ordine);
				System.out.println("Ordini letti!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
				rs.close();
				if(st != null)
				st.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		return set;
	}
	


	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}

