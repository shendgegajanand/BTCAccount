package com.anymind.gajanand.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anymind.gajanand.model.Account;
import com.anymind.gajanand.repository.AccountRepository;
import com.anymind.gajanand.service.intrface.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> findAll() {
		List<Account> accountList = accountRepository.findAll();
		/*
		 * Account private address should not be expose to outside world; hence just return public address and amount of account 
		 * using java8 stream and lambda function
		 */
		List<Account> modifiedAccountList = accountList.stream().map(temp -> {
			Account obj = new Account();
            obj.setPublicAddress(temp.getPublicAddress());
            obj.setTotalAmount(temp.getTotalAmount());
            return obj;
		}).collect(Collectors.toList());
		return modifiedAccountList;
	}

	@Override
	public void deleteById(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Optional<Account> findById(Long id) {
		return accountRepository.findById(id);
	}

	@Override
	public void delete(Account account) {
		accountRepository.delete(account);
	}
	
	@Override
	public Account updateAccount(Account requestAccount, Account existingAccount) {
		existingAccount.setPublicAddress(requestAccount.getPublicAddress());
		existingAccount.setTotalAmount(requestAccount.getTotalAmount());
		return accountRepository.update(existingAccount);
	}

}
