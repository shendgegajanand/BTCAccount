package com.anymind.gajanand.service.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anymind.gajanand.constants.AnyMindConstants;
import com.anymind.gajanand.model.Transaction;
import com.anymind.gajanand.pojo.HistoryResponsePojo;
import com.anymind.gajanand.repository.TransactionRepository;
import com.anymind.gajanand.service.intrface.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Transaction save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}

	@Override
	public List<HistoryResponsePojo> getHistory(Map<String, OffsetDateTime> dateMap) {
		OffsetDateTime startDate = dateMap.get(AnyMindConstants.START_DATE);
		OffsetDateTime endDate = dateMap.get(AnyMindConstants.END_DATE);
		
		OffsetDateTime startDateWithZero = OffsetDateTime.of(startDate.getYear(), startDate.getMonthValue(), startDate.getDayOfMonth(), startDate.getHour(), 00, 00, 00, startDate.getOffset());
		OffsetDateTime endDateWithZero = OffsetDateTime.of(endDate.getYear(), endDate.getMonthValue(), endDate.getDayOfMonth(), endDate.getHour(), 00, 00, 00, endDate.getOffset());
		
		List<HistoryResponsePojo> hourlyTransactionList = new ArrayList<HistoryResponsePojo>();
		while (!startDateWithZero.isAfter(endDateWithZero)) {
			
			List<Transaction> hourTransaction = transactionRepository.findByTransactionTimeWithOffsetBetween(startDateWithZero, startDateWithZero.plusHours(1));
			Double sumOfAmount = hourTransaction.stream().collect(Collectors.summingDouble(Transaction::getAmount));
			HistoryResponsePojo historyResponsePojo = new HistoryResponsePojo();
			historyResponsePojo.setAmount(sumOfAmount);
			historyResponsePojo.setDatetime(startDateWithZero);
			hourlyTransactionList.add(historyResponsePojo);
			
		    startDateWithZero = startDateWithZero.plusHours(1);
		}
		return hourlyTransactionList;
	}

}
