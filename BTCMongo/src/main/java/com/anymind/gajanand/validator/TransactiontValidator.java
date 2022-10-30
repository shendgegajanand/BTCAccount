package com.anymind.gajanand.validator;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anymind.gajanand.constants.AnyMindConstants;
import com.anymind.gajanand.model.Account;
import com.anymind.gajanand.model.Transaction;
import com.anymind.gajanand.pojo.HistoryPojo;
import com.anymind.gajanand.pojo.TransactionPojo;
import com.anymind.gajanand.repository.AccountRepository;
import com.anymind.gajanand.repository.TransactionRepository;
import com.anymind.gajanand.util.AnyMindPropertyUtility;
import com.anymind.gajanand.util.AnyMindUtility;

@Service
public class TransactiontValidator {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AnyMindPropertyUtility propertyUtility;
	
	@Autowired
	AnyMindUtility anyMindUtility;
	
	public Transaction validateTransaction(TransactionPojo transactionPojo) throws Exception {
		double amount = transactionPojo.getAmount();
		if(amount <= 0)
			throw new Exception(propertyUtility.getProperty(AnyMindConstants.INVALID_AMOUNT_ERROR));
		
		//Instance with given offset
		OffsetDateTime odtInstanceAtOffset = anyMindUtility.getDateFromString(transactionPojo.getTransactionTimeWithOffset());
		
		//Instance in UTC
		OffsetDateTime odtInstanceAtUTC = odtInstanceAtOffset.withOffsetSameInstant(ZoneOffset.UTC);
		
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setPublicAddress(propertyUtility.getProperty(AnyMindConstants.ACCOUNT_PUBLIC_KEY));
		transaction.setTransactionTimeWithOffset(odtInstanceAtOffset);
		transaction.setTransactionTimeAtUTC(odtInstanceAtUTC);
		transaction.setCreatedDate(LocalDateTime.now());
		return transaction;
	}
	
	public Map<String, OffsetDateTime> validateHistoryDates(HistoryPojo historyPojo) throws Exception {
		OffsetDateTime startDate = anyMindUtility.getDateFromString(historyPojo.getStartDatetime());
		OffsetDateTime endDate = anyMindUtility.getDateFromString(historyPojo.getEndDatetime());
		Map<String, OffsetDateTime> dateMap = new HashMap<String, OffsetDateTime>();
		dateMap.put(AnyMindConstants.START_DATE, startDate);
		dateMap.put(AnyMindConstants.END_DATE, endDate);
		return dateMap;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
