package com.racing;

public class Horse {

	// Note: intially wanted to keep a HorseNuber ex: #1256 to each horse, which
	// is separate than.
	// can be easily added if required.
	// private int horseNumber;

	private String horseName;

	private int odds;

	private HorseStatus isWinner = HorseStatus.lost;

	Horse() {
		super();
	}

	public Horse(String horseName, int odds) {
		super();
		// this.horseNumber = horseNumber;
		this.horseName = horseName;
		this.odds = odds;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getOdds() {
		return odds;
	}

	public void setOdds(int odds) {
		this.odds = odds;
	}

	public HorseStatus getIsWinner() {
		return isWinner;
	}

	public void setIsWinner(HorseStatus isWinner) {
		this.isWinner = isWinner;
	}

	public boolean equals(Object h) {
		if (!(h instanceof Horse)) {
			return false;
		}
		Horse that = (Horse) h;
		return this.horseName.equalsIgnoreCase(that.horseName);
	}

}
