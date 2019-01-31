package com.bae.Business;

public interface AccountService {
	
	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(Long id);
	String updateAccount(Long id, String account);


}
