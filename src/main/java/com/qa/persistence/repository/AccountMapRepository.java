package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;


import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	
	JSONUtil jsonutil = new JSONUtil();
	private Map<Long, Account> accountMap = new HashMap<>();
	private Long newID = 0L;

	

	public String getAllAccounts() {
		
		
		
		return jsonutil.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {
		
		Account jsonaccount = jsonutil.getObjectForJSON(account, Account.class);
		accountMap.put(newID, jsonaccount);
		newID++;
		return "yes";
		
	}

	public String deleteAccount(Long id) {
		if (accountMap.containsKey(id)) {
		accountMap.remove(id);
		return "removed";
		}else {
			return "failure";
		}
		
	
	}

	public String updateAccount(Long id, String account) {
		
		return null;
	}

	

	public String getAccount() {
		//System.out.println(accountMap.size());
		String jsonaccount = jsonutil.getJSONForObject(accountMap.get(0));
		return jsonaccount;
	}

	

	public Map<Long, Account> getAccountMap() {
		return accountMap;
	}

	public int getFirstNameCount(String firstname) {
		
		int numberOfFirstNamesFound = 0;
		
		
		

		for (Account eachAccount : accountMap.values()) {
			if (eachAccount.getFirstName().equals(firstname)) {
				numberOfFirstNamesFound++;
			}
		}
		return numberOfFirstNamesFound;
		
		
		
		
	}




}
