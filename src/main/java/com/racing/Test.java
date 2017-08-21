package com.racing;

import java.util.ArrayList;

public class Test {

	private  ArrayList<Currency> inventory;
	private int[] notes = new int[5];
//	private int $100 = 0;
//	private int $20 = 0;
//	private int $10 = 0;
//	private int $5 = 0;
//	private int $1 = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> testArray = new ArrayList<String>();
		testArray.add("Zero");
		testArray.add("One");
		testArray.add("Two");
		
		testArray.remove(1);
		System.out.println(testArray);
		
//		Test test = new Test();
//		RaceTrackMachine machine = new RaceTrackMachine();
//		
//		
//		machine.setWinner(7);
//		System.out.println(machine.getHorses().toString());

//		test.setup();
//		
//		int amount = 3000; System.out.print("amount: " + amount);
//		if (test.totalAmount() >= amount)  test.calculate(amount); else System.out.println("No sufficient funds");
//		test.display();
//
//		amount = 250; System.out.print("amount: " + amount);
//		if (test.totalAmount() >= amount)  test.calculate(amount); else System.out.println("No sufficient funds");
//		test.display();
//		
//		amount = 777;  System.out.print("amount: " + amount);
//		if (test.totalAmount() >= amount)  test.calculate(amount); else System.out.println("No sufficient funds");
//		test.display();
//		
//		test.inventory.get(4).setInventory(10);
//		amount = 668; System.out.print("amount: " + amount);
//		if (test.totalAmount() >= amount)  test.calculate(amount); else System.out.println("No sufficient funds");
//		test.display();
//		
//		amount = 26686; System.out.print("amount: " + amount);
//		if (test.totalAmount() >= amount)  test.calculate(amount); else System.out.println("No sufficient funds");
//		test.display();
		
	}
	
	void setup() {
		inventory = new ArrayList<Currency>();
		inventory.add(new Currency(1, 10));
		inventory.add(new Currency(5, 10));
		inventory.add(new Currency(10, 10));
		inventory.add(new Currency(20, 10));
		inventory.add(new Currency(100, 10));
	}

	void calculate(int amount) {
		int tempCount;
		for (int i = inventory.size()-1; i >=0; i --) {
			int denomination = inventory.get(i).getDenomination();
			int remaining = inventory.get(i).getInventory();
			tempCount = amount / denomination;
			if ( tempCount > 0 & remaining > 0) {
				if (tempCount <= remaining) {
					notes[i] += tempCount;
					amount -=  (tempCount * denomination);
					inventory.get(i).setInventory(remaining - tempCount);
				} else {
					notes[i]++;
					amount -= denomination;
					inventory.get(i).setInventory(remaining - 1);
				}
			}
		}
//		int _100 = amount / 100;
//		if ( _100 > 0 & inventory.get(4).getInventory() > 0) {
//			if (_100 <= inventory.get(4).getInventory()) {
//				$100 += _100;
//				amount -=  (_100 * 100);
//				inventory.get(4).setInventory(inventory.get(4).getInventory() - _100);
//			} else {
//				$100++;
//				amount -= 100;
//				inventory.get(4).setInventory(inventory.get(4).getInventory() - 1);
//			}
//		}
//		
//		int _20 = amount / 20;
//		if ( _20 > 0 & inventory.get(3).getInventory() > 0) {
//			if (_20 <= inventory.get(3).getInventory()) {
//				$20 += _20;
//				amount -= (_20 * 20);
//				inventory.get(3).setInventory(inventory.get(3).getInventory() - _20);
//			} else {
//				$20++;
//				amount -= 20;
//				inventory.get(3).setInventory(inventory.get(3).getInventory() - 1);
//			}
//		}
//		
//		int _10 = amount / 10;
//		if ( _10 > 0 & inventory.get(2).getInventory() > 0) {
//			if (_10 <= inventory.get(2).getInventory()) {
//				$10 += _10;
//				amount -= _10 * 10;
//				inventory.get(2).setInventory(inventory.get(2).getInventory() - _10);
//			} else {
//				$10++;
//				amount -= 10;
//				inventory.get(2).setInventory(inventory.get(2).getInventory() - 1);
//			}
//		}
//		
//		int _5 = amount / 5;
//		if ( _5 > 0 & inventory.get(1).getInventory() > 0) {
//			if (_10 <= inventory.get(1).getInventory()) {
//				$5 += _5;
//				amount -= _5 * 5;
//				inventory.get(1).setInventory(inventory.get(1).getInventory() - _5);
//			} else {
//				$5++;
//				amount -= 5;
//				inventory.get(1).setInventory(inventory.get(1).getInventory() - 1);
//			}
//		}
//		
//		int _1 = amount / 1;
//		if ( _1 > 0 & inventory.get(0).getInventory() > 0) {
//			if (_1 <= inventory.get(0).getInventory()) {
//				$1 += _1;
//				amount -= _1;
//				inventory.get(0).setInventory(inventory.get(0).getInventory() - _1);
//			} else {
//				$1++;
//				amount--;
//				inventory.get(0).setInventory(inventory.get(0).getInventory() - 1);
//			}
//		}
		
		if ( amount > 0) calculate (amount);
		
	}
	
	int totalAmount() {
		int amt = 0;
		for (Currency currency : inventory) {
			amt += currency.getDenomination() * currency.getInventory();
		}
		System.out.println("	balance: " + amt);
		return amt;
	}

	void display() {
		System.out.print("$100: " + notes[4]);
		System.out.print("	$20: " + notes[3]);
		System.out.print("	$10: " + notes[2]);
		System.out.print("	$5: " + notes[1]);
		System.out.print("	$1: " + notes[0]);

//		System.out.print("$100: " + $100);
//		System.out.print("	$20: " + $20);
//		System.out.print("	$10: " + $10);
//		System.out.print("	$5: " + $5);
//		System.out.print("	$1: " + $1);
		System.out.println("     " + inventory.toString());
		
//		 $100 =  $20 =  $10 = $5 =  $1 = 0;
		notes = new int[5];
	}
}
