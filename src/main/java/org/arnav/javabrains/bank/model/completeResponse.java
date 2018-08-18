package org.arnav.javabrains.bank.model;

import java.util.ArrayList;
import java.util.List;

public class completeResponse {

	private int aaaTotalRows;
	private List<bwTxnsModel> tableRows;
	
	public int getTotalRows() {
		return aaaTotalRows;
	}
	public void setTotalRows(int aaaTotalRows) {
		this.aaaTotalRows = aaaTotalRows;
	}
	public List<bwTxnsModel> getTableRows() {
		return tableRows;
	}
	public void setTableRows(ArrayList<bwTxnsModel> tableRows) {
		this.tableRows = tableRows;
	}
	
	public completeResponse() {

	}
	
	public completeResponse(int aaaTotalRows, List<bwTxnsModel> list) {
		super();
		this.aaaTotalRows = list.size();
		this.tableRows = list;
	}
	
}
