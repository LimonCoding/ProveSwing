package model;

import java.util.ArrayList;
import java.util.List;

public class AccountList {

	private List<Account> listAccount;
	
	public AccountList() {
		listAccount = new ArrayList<Account>();
	}
	
	public void addAccount(Account account) {
		listAccount.add(account);
	}
	
	public List<Account> getAccount() {
		return listAccount;
	}
}
