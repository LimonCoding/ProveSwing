package controller;

import java.util.List;

import gui.AccountEvent;
import model.Account;
import model.AccountListDatabase;
import model.Card;
import model.Deck;
import model.Discarded;
import model.Game;

public class Controller {
    
    private AccountListDatabase db;
    private Game game;
    
    public void createGame(Account player) {
        game = new Game(player);
//        System.out.println(getDeck().toString());

    }
    
    public Game getGame() {
        return this.game;
    }
    
    public Deck getDeck() {
        return this.game.getDeck();
    }

    public Discarded getDiscard() {
        return this.game.getDiscard();
    }
    
    public boolean legitDiscard(Card card) {
        Card lastDiscard = getDiscard().getLastDiscard();
        return lastDiscard.getColor().equals(card.getColor()) ||
                lastDiscard.getValue().equals(card.getValue()) ||
                card.isWild() || lastDiscard.isWild();
    }
    
	public void createAccountList() {
	    db = new AccountListDatabase();
    }
	
	public List<Account> getAccounts() {
		return db.getAccounts();
	}
	
	public Account getAccount(int id) {
	    return db.getAccounts().get(id);
    }
	
	public void addAccount(AccountEvent ev) {
		String alias = ev.getAlias();
		int level = ev.getLevel();
		Account account = new Account(alias, level);
		db.addAccount(account);
	}
}
