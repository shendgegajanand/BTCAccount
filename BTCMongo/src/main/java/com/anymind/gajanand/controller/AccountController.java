package com.anymind.gajanand.controller;

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
import com.anymind.gajanand.service.intrface.AccountService;
import com.anymind.gajanand.util.AnyMindUtility;
import com.anymind.gajanand.validator.AccountValidator;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

	@Autowired
    private AccountService accountService;
	
	@Autowired
    private AccountValidator accountValidator;
  
    @PostMapping("/addAccount")
    public Account saveAccount(@RequestBody Account account){
    	return accountService.save(account);
    }
  
    @GetMapping("/findAllAccounts")
    public List<Account> getAccounts() {
        return accountService.findAll();
    }
  
    @DeleteMapping("/delete/{id}")
    public Map < String, Boolean > deleteAccount(@PathVariable Long id) throws Exception {
    	Account account = accountValidator.checkAccountPresent(id);
    	accountService.delete(account);
    	Map < String, Boolean > response = new HashMap < > ();
        response.put("Account deleted", Boolean.TRUE);
        return response;
    }
    
    @GetMapping("/account/{id}")
    public ResponseEntity < Account > getAccountById(@PathVariable(value = "id") Long id)
    throws Exception {
    	Account account = accountValidator.checkAccountPresent(id);
    	Account tempAccount = AnyMindUtility.getTempAccount(account);
        return ResponseEntity.ok().body(tempAccount);
    }
    
    @PutMapping("/account/{id}")
    public ResponseEntity < Account > updateAccount(@PathVariable(value = "id") Long id, @RequestBody Account requestAaccount)
    throws Exception {
    	Account existingAccount = accountValidator.checkAccountPresent(id);
    	accountService.updateAccount(requestAaccount, existingAccount);
    	Account tempAccount = AnyMindUtility.getTempAccount(existingAccount);
        return ResponseEntity.ok().body(tempAccount);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
