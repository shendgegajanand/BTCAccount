package com.anymind.gajanand.service.intrface;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anymind.gajanand.model.Account;

@Service
public interface AccountService {

	Account save(Account account);
	
	List<Account> findAll();
	
	void deleteById(Long id);
	
	void delete(Account account);
	
	Optional<Account> findById(Long id);
	
	Account updateAccount(Account requestAccount, Account existingAccount);
}
