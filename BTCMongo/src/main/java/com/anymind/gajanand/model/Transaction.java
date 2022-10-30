package com.anymind.gajanand.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Transaction {
	
	@Id private int id;
	
	private String publicAddress;
	
	private double amount;
	
	//Instance with given offset
	OffsetDateTime transactionTimeWithOffset;
	
	//Instance in UTC
	OffsetDateTime transactionTimeAtUTC;
	
	private LocalDateTime createdDate;
	
	public String getPublicAddress() {
		return publicAddress;
	}

	public void setPublicAddress(String publicAddress) {
		this.publicAddress = publicAddress;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public OffsetDateTime getTransactionTimeWithOffset() {
		return transactionTimeWithOffset;
	}

	public void setTransactionTimeWithOffset(OffsetDateTime transactionTimeWithOffset) {
		this.transactionTimeWithOffset = transactionTimeWithOffset;
	}

	public OffsetDateTime getTransactionTimeAtUTC() {
		return transactionTimeAtUTC;
	}

	public void setTransactionTimeAtUTC(OffsetDateTime transactionTimeAtUTC) {
		this.transactionTimeAtUTC = transactionTimeAtUTC;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
