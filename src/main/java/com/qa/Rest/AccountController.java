package com.qa.Rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.bae.Business.AccountService;

@Path("/Account")
public class AccountController {
	
	@Inject
	private AccountService service;
	
	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.createAccount(account);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteAccount(id);
	}
	
	@Path("/updateAccount/{id}")
	@PUT
//	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id,  String account) {
		return service.updateAccount(id, account);
	}
	
	public void setService(AccountService service) {
		this.service = service;
	}
	
	
	
	

}
