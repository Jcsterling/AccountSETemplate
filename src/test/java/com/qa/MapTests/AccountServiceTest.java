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

	JSONUtil jsonutil;
	AccountMapRepository service;
	

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
		assertEquals(jsonaccount, service.getAccount());
	}

	@Test
	public void add2AccountTest() {
		
		

	}

	@Test
	public void removeAccountTest() {
//		Account testAcount2 = new Account();
//		service.deleteAccount();

	}

	@Test
	public void remove2AccountTest() {

	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {

	}

	@Test
	public void accountConversionToJSONTestWithEmptyMap() {

	}

	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {

	}

	@Test
	public void accountConversionToJSONTest() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {

	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {

	}

}
