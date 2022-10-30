package com.anymind.gajanand.service.intrface;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anymind.gajanand.model.Account;
import com.anymind.gajanand.model.Transaction;
import com.anymind.gajanand.pojo.HistoryResponsePojo;

@Service
public interface TransactionService {

	Transaction save(Transaction transaction);
	
	List<Transaction> findAll();
	
	List<HistoryResponsePojo> getHistory(Map<String, OffsetDateTime> dateMap);
	
}
