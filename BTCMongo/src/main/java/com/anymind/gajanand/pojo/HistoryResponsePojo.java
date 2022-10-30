package com.anymind.gajanand.pojo;

import java.time.OffsetDateTime;

public class HistoryResponsePojo {

	OffsetDateTime datetime;
	
	double amount;

	public OffsetDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(OffsetDateTime datetime) {
		this.datetime = datetime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
