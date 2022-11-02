package controller;

import java.util.List;

import gui.AccountEvent;
import model.Account;
import model.AccountList;

public class Controller {

	AccountList accList = new AccountList();
	
	public List<Account> getAccounts() {
		return accList.getAccount();
	}
	
	public void addAccount(AccountEvent ev) {
		String alias = ev.getAlias();
		int level = ev.getLevel();
		
		Account account = new Account(alias, level);
		accList.addAccount(account);
		
		accList.getAccount().stream().forEach(
				(accListTemp) -> 
					System.out.println( "ID: " + accListTemp.getId() + " - " +
							accListTemp.getAlias() + 
							" - Level: " + accListTemp.getLevel())
		);
	}
}
