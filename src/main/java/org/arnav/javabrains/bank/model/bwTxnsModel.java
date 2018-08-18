package org.arnav.javabrains.bank.model;

public class bwTxnsModel {
	
	private int txnId;
	private String BSBNumber;
	private int accountNumber;
	private String txnDate;
	private String narration;
	private String chqNo;
	private double debitAmount;
	private double creditAmount;
	private double balance;
	private String txnType;
	
	public bwTxnsModel()	{
		
	}
	
	public bwTxnsModel(int txnId, String bSBNumber, int accountNumber, String txnDate, String narration, String chqNo,
			double debitAmount, double creditAmount, double balance, String txnType) {
		this.txnId = txnId;
		BSBNumber = bSBNumber;
		this.accountNumber = accountNumber;
		this.txnDate = txnDate;
		this.narration = narration;
		this.chqNo = chqNo;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.balance = balance;
		this.txnType = txnType;
	}

	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public String getBSBNumber() {
		return BSBNumber;
	}
	public void setBSBNumber(String bSBNumber) {
		BSBNumber = bSBNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public String getChqNo() {
		return chqNo;
	}
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	public double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

}
