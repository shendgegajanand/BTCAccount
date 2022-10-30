package com.anymind.gajanand.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.anymind.gajanand.model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, Integer> {
	
	public List<Transaction> getTransaction();
	
	List<Transaction> findByTransactionTimeWithOffsetBetween(OffsetDateTime startDate, OffsetDateTime endDate);
}
