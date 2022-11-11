package model;

import java.util.ArrayList;
import java.util.List;

public class AccountListDatabase {

	private ArrayList<Account> listAccount;
	
	public AccountListDatabase() {
		listAccount = new ArrayList<Account>();
	}
	
	public void addAccount(Account account) {
		listAccount.add(account);
	}
	
	public List<Account> getAccounts() {
		return listAccount;
	}
}
