package com.qa.persistence.repository;



import java.util.List;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountServiceDBImpl implements AccountRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil jsonutil;
	
	public String getAllAccounts() {
		
		TypedQuery<Account> query = em.createQuery("SELECT m FROM Account m", Account.class);
		
//		Query query = em.createQuery("SELECT m FROM ACCOUNT m", Account.class);
//		List<Account> accounts = (List<Account>) query.getResultList();
//		String jsonaccount = jsonutil.getJSONForObject(accounts);
		return jsonutil.getJSONForObject(query.getResultList());
	}


	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account objectAccount = jsonutil.getObjectForJSON(account, Account.class);
		em.persist(objectAccount);
		return "{\"message\": \"movie sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountToDelete = em.find(Account.class, id);
		if (accountToDelete != null) {
			em.remove(accountToDelete);
		}
		
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		Account accountToDelete = em.find(Account.class, id);
		if (accountToDelete != null) {
			em.remove(accountToDelete);
			Account objectAccount = jsonutil.getObjectForJSON(account, Account.class);
			em.persist(objectAccount);
		}
		
		return "{\"message\": \"account sucessfully updated\"}";
	}

}
