package com.racing;

import java.util.ArrayList;
import java.util.List;

public class RaceTrackMachine {

	private List<Currency> inventory;

	private List<Horse> horses;

	private int[] notes;

	int amt;

	public RaceTrackMachine() {
		super();
		inventory = new ArrayList<Currency>();
		inventory.add(new Currency(1, 10));
		inventory.add(new Currency(5, 10));
		inventory.add(new Currency(10, 10));
		inventory.add(new Currency(20, 10));
		inventory.add(new Currency(100, 10));

		notes = new int[inventory.size()];

		horses = new ArrayList<Horse>();
		horses.add(new Horse("That Darn Gray Cat", 5));
		horses.add(new Horse("Fort Utopia", 10));
		horses.add(new Horse("Count Sheep", 9));
		horses.add(new Horse("Ms Traitour", 4));
		horses.add(new Horse("Real Princess", 3));
		horses.add(new Horse("Pa Kettle", 5));
		horses.add(new Horse("Gin Stinger", 6));

		horses.get(0).setIsWinner(HorseStatus.won);

	}

	public void restockCash(int max) {
		for (Currency currency : inventory) {
			currency.setInventory(max);
		}
	}

	public void setWinner(int horseNumber) {
		if (0 < horseNumber && horseNumber <= horses.size()) {
			for (int i = 0; i < horses.size(); i++) {
				horses.stream().filter(h -> h.getIsWinner()  == HorseStatus.won).forEach(h -> h.setIsWinner(HorseStatus.lost));
//				if (horses.get(i).getIsWinner() == HorseStatus.won) {
//					horses.get(i).setIsWinner(HorseStatus.lost);
//				}
			}
			horses.get(--horseNumber).setIsWinner(HorseStatus.won);
		} else {
			System.out.println("Invalid Horse Number: " + horseNumber);
		}

	}

	public void payout(int horseNumber, int bet) {

		if (horseNumber > horses.size()) {
			System.out.println("Invalid Horse Number: " + horseNumber);
			return;
		}

		Horse chosenHorse = horses.get(--horseNumber);
		if (chosenHorse.getIsWinner() == HorseStatus.won) {
			int winningAmount = chosenHorse.getOdds() * bet;
			if (winningAmount > totalInventoryBalance()) {
				System.out.println("Insufficient Funds: $" + winningAmount);
			} else {
				calculate(chosenHorse.getOdds() * bet);
				System.out.println("Payout: " + chosenHorse.getHorseName() + "," + winningAmount);
				displayPayout();
			}
		} else {
			System.out.println("No Payout: " + chosenHorse.getHorseName());
		}
	}

	void calculate(int amount) {
		int tempCount;
		for (int i = inventory.size() - 1; i >= 0; i--) {
			int denomination = inventory.get(i).getDenomination();
			int remaining = inventory.get(i).getInventory();
			tempCount = amount / denomination;
			if (tempCount > 0 & remaining > 0) {
				if (tempCount <= remaining) {
					notes[i] += tempCount;
					amount -= (tempCount * denomination);
					inventory.get(i).setInventory(remaining - tempCount);
				} else {
					notes[i]++;
					amount -= denomination;
					inventory.get(i).setInventory(remaining - 1);
				}
			}
		}
		if (amount > 0)
			calculate(amount);
	}

	int totalInventoryBalance() {
		amt = 0;
		inventory.parallelStream().forEach(c -> amt += c.getDenomination() * c.getInventory());
		return amt;
	}

	public void addHorse(String horseName, int odd) {
		Horse horse = new Horse(horseName, odd);
		if ( horses.contains(horse)) {
			System.out.println("Invalid addition: " + horseName + " is already in the race."  );
		} else {
			horses.add(horse);
		}
	}
	
	public void removeHorse (int horseNumber) {
		if (horseNumber < 1 || horseNumber > horses.size() ) {
			System.out.println("Invalid Horse Number: " + horseNumber);
		} else {
			horses.remove(--horseNumber);
		}
	}

	void displayPayout() {
		System.out.println("Dispensing:");
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println("$" + inventory.get(i).getDenomination() + ":" + notes[i]);
		}
		// clear the dispensing currency count, to reuse the array for next round.
		notes = new int[inventory.size()];
	}

	public int[] getNotes() {
		return notes;
	}
	
	public List<Currency> getInventory() {
		return inventory;
	}

	public void setInventory(List<Currency> inventory) {
		this.inventory = inventory;
	}

	public List<Horse> getHorses() {
		return horses;
	}

	public void setHorses(List<Horse> horses) {
		this.horses = horses;
	}

}
