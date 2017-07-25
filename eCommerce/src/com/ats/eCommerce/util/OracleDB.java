package com.ats.eCommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDB implements com.ats.eCommerce.dao.DaoConstant {
	
	private static Connection connection;
	
	public static Connection getConnection(){
		
		///reflection
		// cosi facendo ho listanza del oracle driver
		//factory metody
		try {//definizione della classe
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
