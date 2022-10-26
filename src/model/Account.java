package model;

import javax.swing.ImageIcon;

public class Account {

	private String alias;
	private int level = 0;
	private ImageIcon accountIcon;
	
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
}
