package com.anymind.gajanand.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.anymind.gajanand.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, Long> {
	
	@Query("{name:'?0'}")
    Account findAccountByPublicAddress(String publicAddress);
    
    public long count();
    
    public void delete(Account account);
    
    public Account update(Account account);
    
}
