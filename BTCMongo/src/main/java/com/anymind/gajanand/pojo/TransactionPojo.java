package com.anymind.gajanand.pojo;

import java.time.OffsetDateTime;

public class TransactionPojo {

	//Instance with given offset
	String transactionTimeWithOffset;
		
	private double amount;
	
	
	public String getTransactionTimeWithOffset() {
		return transactionTimeWithOffset;
	}


	public void setTransactionTimeWithOffset(String transactionTimeWithOffset) {
		this.transactionTimeWithOffset = transactionTimeWithOffset;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
