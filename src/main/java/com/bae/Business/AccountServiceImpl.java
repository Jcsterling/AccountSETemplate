package com.bae.Business;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;


public class AccountServiceImpl {
	
	private JSONUtil jsonutil;

	@Inject
	private AccountRepository repository;
	
	
	public String getAllaccounts() {
		return repository.getAllAccounts();	
	}
	
	public String createAccount(String account) {
		Account objectAccount = jsonutil.getObjectForJSON(account, Account.class);
		if (objectAccount.getAccNumber().equals("9")) {
			return "{“message”: “This account is blocked”}";
		}
		return repository.createAccount(account);
		
	}
	
	public String deleteAccount(Long id) {
		return repository.deleteAccount(id);
		
	}
	
	public String updateAccount(String account, Long id) {
		return repository.updateAccount(id, account);
	}
}
