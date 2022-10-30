package com.anymind.gajanand.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {
	
	@Id private int id;
	
    @Indexed(unique = true)
	private String publicAddress;
	
	private String privateAddress;
	
	private LocalDateTime createdDate;
	
	private double totalAmount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublicAddress() {
		return publicAddress;
	}

	public void setPublicAddress(String publicAddress) {
		this.publicAddress = publicAddress;
	}

	public String getPrivateAddress() {
		return privateAddress;
	}

	public void setPrivateAddress(String privateAddress) {
		this.privateAddress = privateAddress;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
