package com.racing;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class HorseTrack {

	RaceTrackMachine machine;

	public static void main(String[] args) {
		new HorseTrack().startMachine();
	}

	public void startMachine() {

		machine = new RaceTrackMachine();
		displayMachineStatus();

		String choice = "";

		Scanner scanner = new Scanner(System.in);
		while (!choice.equalsIgnoreCase("q") && scanner.hasNextLine()) {
			if (scanner.hasNextInt()) {  // checking if the next command is number based before reading, instead of handling NumberFormatException after reading.
				choice = scanner.next();
				if (scanner.hasNextInt()) {
					machine.payout(Integer.parseInt(choice), scanner.nextInt());
				} else if (scanner.hasNext()) {
					System.out.println("Invalid Bet: " + scanner.next());
				}
			} else { 
				choice = scanner.next();
				
				switch (choice.toLowerCase()) {
				case "r" : 
					// future Note:- if want to have an option to mention the max inventory of currency, while re-stocking.
					/*
					 * int max = 0; if (scanner.hasNextInt()) max =
					 * scanner.nextInt(); if (max > 0) {
					 * System.out.println("will stock to max " + max);
					 * machine.restockCash(max); } else {
					 */
					machine.restockCash(10);
					break;
					
				case "w" :
					if (scanner.hasNextInt()) { // wait for the patron to enter valid bet amount.
						machine.setWinner(scanner.nextInt());
					} else {
						System.out.println("Invalid Command: " + choice + " " + scanner.next());
					}
					break;
				
				case "a" : // System.out.println("feature to add horse coming soon.");
							// call machine.addHorse(horseName, odd);
							machine.addHorse("sample Horse", 1);
							break;
	
				case "rm": if ( scanner.hasNext()) {
								String horseNumber = scanner.next();
								try {
									machine.removeHorse(Integer.parseInt(horseNumber));
								} catch (NumberFormatException e) {
									System.out.println("Invalid Horse Number: " + horseNumber);
								}
							}
							break;

				case "e" : System.out.println("feature to edit horse details coming soon!!");
							break;

				case "q" : System.out.println("Closing the application.");
							break;
				
				default: System.out.println("Invalid Command: " + choice);
				}
			}

			displayMachineStatus();
		}
		scanner.close();

	}

	void displayMachineStatus() {
		System.out.println("Inventory:");
		machine.getInventory().stream().forEach(
				currency -> System.out.println("$" + currency.getDenomination() + "," + currency.getInventory()));

		System.out.println("Horses:");
		AtomicInteger count = new AtomicInteger();
		machine.getHorses().stream().forEach(horse -> System.out.println(count.incrementAndGet() + ","
				+ horse.getHorseName() + "," + horse.getOdds() + "," + horse.getIsWinner()));
	
		System.out.println();
	}

	public RaceTrackMachine getMachine() {
		return machine;
	}

}
