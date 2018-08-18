package org.arnav.javabrains.bank.errors;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.arnav.javabrains.bank.model.bwTxnsModel;

@XmlRootElement
public class errorDb {
	
	private String SQLException;
	private int SQLState;
	private int VendorError;
	
	public errorDb()	{
		
	}
	
	public errorDb(String sQLException, int sQLState, int vendorError) {
		super();
		SQLException = sQLException;
		SQLState = sQLState;
		VendorError = vendorError;
	}
	
	public String getSQLException() {
		return SQLException;
	}
	public void setSQLException(String sQLException) {
		SQLException = sQLException;
	}
	public int getSQLState() {
		return SQLState;
	}
	public void setSQLState(int sQLState) {
		SQLState = sQLState;
	}
	public int getVendorError() {
		return VendorError;
	}
	public void setVendorError(int vendorError) {
		VendorError = vendorError;
	}

}
