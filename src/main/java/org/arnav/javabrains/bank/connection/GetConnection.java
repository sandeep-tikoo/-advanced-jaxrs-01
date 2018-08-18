package org.arnav.javabrains.bank.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    
    public static Connection getConnection(String url, String user, String pass) throws SQLException	{
    	
			return DriverManager.getConnection(url, user, pass);

    }
    
}
