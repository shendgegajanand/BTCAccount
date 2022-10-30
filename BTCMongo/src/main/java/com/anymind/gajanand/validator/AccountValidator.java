package com.anymind.gajanand.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anymind.gajanand.model.Account;
import com.anymind.gajanand.repository.AccountRepository;
import com.anymind.gajanand.util.AnyMindUtility;

@Service
public class AccountValidator {

	@Autowired
	AccountRepository accountRepository;
	
	public Account checkAccountPresent(Long id) throws Exception {
		if(AnyMindUtility.isEmpty(id))
			throw new Exception("Please provide valid account id...!");
		Optional<Account> account = accountRepository.findById(id);
		if(account.isPresent()) {
			return account.get();
		}
		throw new Exception("Account not found with given id...!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
