package model;

import javax.swing.ImageIcon;

public class Account {
	
	private static int count = 0;

	private int id;
	private String alias;
	private int level = 0;
	private ImageIcon accountIcon;
	
	public Account(String alias, int level) {
		this.alias = alias;
		this.level = level;
		
		this.id = count;
		count++;
	}
	
	public Account(String alias, int level, ImageIcon accountIcon) {
		this.alias = alias;
		this.level = level;
		this.accountIcon = accountIcon;
		
		this.id = count;
		count++;
	}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public ImageIcon getAccountIcon() {
		return accountIcon;
	}
	public void setAccountIcon(ImageIcon accountIcon) {
		this.accountIcon = accountIcon;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
