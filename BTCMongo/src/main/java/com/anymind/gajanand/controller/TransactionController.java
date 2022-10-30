package com.anymind.gajanand.controller;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anymind.gajanand.exception.ResourceNotFoundException;
import com.anymind.gajanand.model.Account;
import com.anymind.gajanand.model.Transaction;
import com.anymind.gajanand.pojo.HistoryPojo;
import com.anymind.gajanand.pojo.HistoryResponsePojo;
import com.anymind.gajanand.pojo.TransactionPojo;
import com.anymind.gajanand.service.intrface.AccountService;
import com.anymind.gajanand.service.intrface.TransactionService;
import com.anymind.gajanand.util.AnyMindUtility;
import com.anymind.gajanand.validator.AccountValidator;
import com.anymind.gajanand.validator.TransactiontValidator;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

	@Autowired
    private AccountService accountService;
	
	@Autowired
    private TransactionService transactionService;
	
	@Autowired
    private TransactiontValidator transactionValidator;
  
    @PostMapping("/addTransaction")
    public Transaction saveTransaction(@RequestBody TransactionPojo transactionPojo) throws Exception	{
    	Transaction transaction = transactionValidator.validateTransaction(transactionPojo);
    	return transactionService.save(transaction);
    }
  
    @GetMapping("/findAllAccounts")
    public List<Transaction> getAccounts() {
        return transactionService.findAll();
    }
  
    @PostMapping("/getHistoryBetweenTwoDates")
    public List<HistoryResponsePojo> getHistory(@RequestBody HistoryPojo historyPojo) throws Exception {
    	Map<String, OffsetDateTime> dateMap = transactionValidator.validateHistoryDates(historyPojo);
    	return transactionService.getHistory(dateMap);
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
