package controller;

import java.util.ArrayList;
import java.util.List;

import gui.AccountEvent;
import model.Account;
import model.AccountListDatabase;
import model.Card;
import model.Deck;
import model.Game;

public class Controller {
    
    private Deck deck;
    List<Card> handCards;
    AccountListDatabase db;
    private Game game;
    
    public void createGame(Account player) {
        deck = new Deck();
        game = new Game(player);
        handCards = new ArrayList<>();
        handCards.add(deck.getCard());
        handCards.add(deck.getCard());
        game.getTopPlayer().setHandCards(handCards);;
    }
    
    public Game getGame() {
        return this.game;
    }
    
    public void createDeck() {
        deck = new Deck();
    }
    
    public Deck getDeck() {
        return this.deck;
    }

	public void createAccountList() {
	    db = new AccountListDatabase();
    }
	
	public List<Account> getAccounts() {
		return db.getAccounts();
	}
	
	public void addAccount(AccountEvent ev) {
		String alias = ev.getAlias();
		int level = ev.getLevel();
		
		Account account = new Account(alias, level);
		db.addAccount(account);
	}
}
