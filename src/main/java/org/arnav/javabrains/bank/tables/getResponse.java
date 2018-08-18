package org.arnav.javabrains.bank.tables;

import org.arnav.javabrains.bank.model.completeResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class getResponse {

	public static completeResponse GetResponse(ResultSet rs) throws SQLException {
	
		completeResponse CR = new completeResponse(0,bwTxns.getBwTxns(rs));
		return CR;

//		return null;
	}
	
	
}
