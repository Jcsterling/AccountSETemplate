package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	
	JSONUtil jsonutil = new JSONUtil();
	private Map<Integer, Account> accountMap = new HashMap<>();
	private int newID = 0;
//	Long accID = new Long(newID);
	

	public String getAllAccounts() {
		accountMap.size();
		
		
		return null;
	}

	public String createAccount(String account) {
		
		Account jsonaccount = jsonutil.getObjectForJSON(account, Account.class);
		accountMap.put(newID, jsonaccount);
		newID++;
		
		
	
		
		return "yes";
		
		
	}

	public String deleteAccount(Long id) {
		accountMap.remove(id);
		// TODO Auto-generated method stub
		return "deleted";
	}

	public String updateAccount(Long id, String account) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public String getAccount() {
		System.out.println(accountMap.size());
		
		
		String jsonaccount = jsonutil.getJSONForObject(accountMap.get(0));
		
		
		return jsonaccount;
	}

	

	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	public void setAccountMap(Map<Integer, Account> accountMap) {
		this.accountMap = accountMap;
	}

	@Override
	public String toString() {
		return "AccountMapRepository [accountMap=" + accountMap + ", newID=" + newID + ", getAllAccounts()="
				+ getAllAccounts() + ", getAccount()=" + getAccount() + "]";
	}



}
