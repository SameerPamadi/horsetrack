package com.racing;

public class Currency {

	private int denomination;
	
	private int inventory;
	
	private int maxCount = 10;
	
	public Currency() {
		super();
	}

	
	public Currency(int denomination, int inventory) {
		super();
		
		this.denomination = denomination;
		this.inventory = inventory;
	}


	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}


	@Override
	public String toString() {
		return "$" + denomination + ": " + inventory;
	}
	
	
	
	
	
}
