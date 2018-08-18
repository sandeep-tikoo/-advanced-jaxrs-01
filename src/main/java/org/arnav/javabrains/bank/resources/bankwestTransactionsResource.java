package org.arnav.javabrains.bank.resources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.arnav.javabrains.bank.connection.GetConnection;
import org.arnav.javabrains.bank.errors.errorDb;
import org.arnav.javabrains.bank.model.bwTxnsModel;
import org.arnav.javabrains.bank.model.completeResponse;
import org.arnav.javabrains.bank.tables.bwTxns;
import org.arnav.javabrains.bank.tables.getResponse;

@Path ("bwtxns")
@XmlRootElement

public class bankwestTransactionsResource {
		
	@QueryParam("name") private String queryParam;
	private static final String URL   = "jdbc:mysql://localhost:3306/deepu";
	private static final String USER  = "root";
	private static final String PASS  = "password";

    	@GET
    	@Produces(MediaType.APPLICATION_JSON)
//    	public List<bwTxnsModel> getMessages() throws ClassNotFoundException, SQLException     	{
    	public completeResponse getMessages() throws ClassNotFoundException, SQLException     	{
    		System.out.println("about to Connect " + URL + "#" + USER + "#" + PASS);
    		try	{	
//    		(
    				Class.forName("com.mysql.cj.jdbc.Driver");
    				Connection conn = GetConnection.getConnection(URL, USER, PASS);
//    				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    				Statement stmt = conn.createStatement();
    				ResultSet rs = stmt.executeQuery("SELECT * FROM bw_txn;");
//    			)
//    		{
                System.out.println("Connected to: " + URL);
//                return bwTxns.getBwTxns(rs);
                 return getResponse.GetResponse(rs);

            } 
    		catch (SQLException e) {
                System.out.println("SQLException: "+ e.getMessage());
                System.out.println("SQLState: "+ e.getSQLState());
                System.out.println("VendorError: "+ e.getErrorCode());
//                return errorDb.errorDb(e.getMessage(),e.getSQLState(), e.getErrorCode());
                return null;
            }
		}

}