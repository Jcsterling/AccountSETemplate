package com.qa.MapTests;

import static org.junit.Assert.*;

import javax.swing.JScrollBar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private JSONUtil jsonutil;
	private AccountMapRepository service;
	

	@Before
	public void setup() {

		jsonutil = new JSONUtil();
		service = new AccountMapRepository();
		

	}

	@Test
	public void testAccount() {
		Account testAccount1 = new Account();
		assertEquals("james", testAccount1.getFirstName());
		assertEquals("jamerson", testAccount1.getLastName());
		assertEquals("1", testAccount1.getAccNumber());
	}

	@Test
	public void addAccountTest() {

		Account testAccount2 = new Account("max", "branning", "004");

		//turn testAccount2 object in to a string 
		String jsonaccount = jsonutil.getJSONForObject(testAccount2);
		service.createAccount(jsonaccount);
		
		//making array that contains account objects. the object were originally strings. they had been 
		//converted to strings in the get all accounts methods 
		Account[] account = jsonutil.getObjectForJSON(service.getAllAccounts(), Account[].class);
		assertEquals(1, account.length);
	 
		//using the accountMap getter to check size -- easier way 
		assertEquals(1, service.getAccountMap().size());
	}

	@Test
	public void add2AccountTest() {

		Account testAccount2 = new Account("max", "branning", "004");
		Account testAccount3 = new Account("misty", "brown", "006");

		//turn testAccount2 object in to a string 
		String jsonaccount = jsonutil.getJSONForObject(testAccount2);
		String jsonaccount1 = jsonutil.getJSONForObject(testAccount3);
		service.createAccount(jsonaccount);
		service.createAccount(jsonaccount1);
		assertEquals(2, service.getAccountMap().size());
		
	}

	@Test
	public void removeAccountTest() {
		Account testAccount3 = new Account("send", "n", "007");
		String jsonaccount = jsonutil.getJSONForObject(testAccount3); 
		service.createAccount(jsonaccount);
		service.deleteAccount(0L);
		assertEquals(0, service.getAccountMap().size());

	}

	@Test
	public void remove2AccountTest() {
		
		Account testAccount4 = new Account("send", "n", "007");
		Account testAccount5 = new Account("send", "nudes", "008");
		String jsonaccount = jsonutil.getJSONForObject(testAccount4); 
		String jsonaccount1 = jsonutil.getJSONForObject(testAccount5); 
		service.createAccount(jsonaccount);
		service.createAccount(jsonaccount1);
		service.deleteAccount(0L);
		service.deleteAccount(1L);
		assertEquals(0, service.getAccountMap().size());


	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		
		Account testAccount6 = new Account("am", "smith", "007");
		Account testAccount7 = new Account("jim", "weezy", "008");
		String jsonaccount = jsonutil.getJSONForObject(testAccount6); 
		String jsonaccount1 = jsonutil.getJSONForObject(testAccount7); 
		service.createAccount(jsonaccount);
		service.createAccount(jsonaccount1);
		service.deleteAccount(0L);
		service.deleteAccount(1L);
//		service.deleteAccount(2); already calling this method in the assert statement.
		assertEquals("failure", service.deleteAccount(2L));
		assertEquals(0, service.getAccountMap().size());


	}

	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
		
		

	}

	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {

	}

	@Test
	public void accountConversionToJSONTest() {
		Account testAccount0 = new Account("wendy", "singh", "1994443");
		String jsonaccount = jsonutil.getJSONForObject(testAccount0); 
		//System.out.println(jsonaccount);
		assertEquals("{\"firstName\":\"wendy\",\"lastName\":\"singh\",\"accNumber\":\"1994443\"}", jsonaccount);
		

	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		
		Account testAccount9 = new Account("marcus", "brown", "007111");
		Account testAccount10 = new Account("jima", "kanban", "008545");
		String jsonaccount = jsonutil.getJSONForObject(testAccount9); 
		String jsonaccount1 = jsonutil.getJSONForObject(testAccount10); 
		service.createAccount(jsonaccount);
		service.createAccount(jsonaccount1);
		
		assertEquals(0, service.getFirstNameCount("john"));

	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		

		Account testAccount11 = new Account("john", "brown", "007111");
		Account testAccount12 = new Account("jima", "kanban", "008545");
		String jsonaccount = jsonutil.getJSONForObject(testAccount11); 
		String jsonaccount1 = jsonutil.getJSONForObject(testAccount12); 
		service.createAccount(jsonaccount);
		service.createAccount(jsonaccount1);
		
		assertEquals(1, service.getFirstNameCount("john"));


	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		

		Account testAccount13 = new Account("john", "brown", "007111");
		Account testAccount14 = new Account("john", "kanban", "008545");
		String jsonaccount = jsonutil.getJSONForObject(testAccount13); 
		String jsonaccount1 = jsonutil.getJSONForObject(testAccount14); 
		service.createAccount(jsonaccount);
		service.createAccount(jsonaccount1);
		
		assertEquals(2, service.getFirstNameCount("john"));


	}

}
