package org.arnav.javabrains.bank.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.arnav.javabrains.bank.model.bwTxnsModel;

public class bwTxns {

		public static List<bwTxnsModel> getBwTxns(ResultSet rs) throws SQLException	{
			ArrayList<bwTxnsModel> txnArray = new ArrayList<>();
			while (rs.next()) {
				bwTxnsModel bwTxnsInstance = new bwTxnsModel(rs.getInt("bw_txn_id")
						, rs.getString("BSB_Number")
						, rs.getInt("Account_Number")
						, rs.getString("Transaction_Date")
						, rs.getString("Narration")
						, rs.getString("Cheque_Number")
						, rs.getDouble("Debit")
						, rs.getDouble("Credit")
						, rs.getDouble("Balance")
						, rs.getString("Transaction_Type"));
				
//				System.out.println(bwTxnsInstance.getAccountNumber() + " " + bwTxnsInstance.getBalance());
				txnArray.add(bwTxnsInstance);

			}
//			return bwTxnsInstance;
			int size = txnArray.size();
			System.out.println("Total Rows: " + txnArray.size());
			return txnArray;
		}
}
