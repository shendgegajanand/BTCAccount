package com.anymind.gajanand.response;

import java.util.List;

import com.anymind.gajanand.pojo.HistoryResponsePojo;

public class HistoryResponse {

	List<HistoryResponsePojo> transactionList;

	public List<HistoryResponsePojo> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<HistoryResponsePojo> transactionList) {
		this.transactionList = transactionList;
	}
}
