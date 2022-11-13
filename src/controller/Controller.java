package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gui.AccountEvent;
import model.Account;
import model.AccountListDatabase;
import model.Deck;
import model.Discard;
import model.Game;

public class Controller {
    
    private Deck deck;
    private Discard discard;
    private AccountListDatabase db;
    private Game game;
    
    public void createGame(Account player) {
        deck = new Deck();
        discard = new Discard();
        game = new Game(player);
        System.out.println(getDeck().toString());
        discard.setDiscard(deck.getCard());
        game.getTopPlayer().setHandCards(new ArrayList<>(Arrays.asList(deck.getCard(), deck.getCard())));
        game.getRightPlayer().setHandCards(new ArrayList<>(Arrays.asList(deck.getCard(), deck.getCard())));
        game.getLeftPlayer().setHandCards(new ArrayList<>(Arrays.asList(deck.getCard(), deck.getCard())));
        game.getBottomPlayer().setHandCards(new ArrayList<>(Arrays.asList(deck.getCard(), deck.getCard())));

    }
    
    public Game getGame() {
        return this.game;
    }
    
    public Deck getDeck() {
        return this.deck;
    }

    public Discard getDiscard() {
        return this.discard;
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
