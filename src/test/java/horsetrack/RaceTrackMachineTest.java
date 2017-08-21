package horsetrack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.racing.HorseStatus;
import com.racing.RaceTrackMachine;

public class RaceTrackMachineTest {

	RaceTrackMachine machine;
	
	@Before
	public void setup() {
		 machine = new RaceTrackMachine();
	}
	
	@Test
	public void testRestock() {
		machine.restockCash(10);
		assertEquals("test inventory count for a currency. " , 10, machine.getInventory().get(0).getInventory());
		assertNotEquals("test wrong inventory. ", 17, machine.getInventory().get(3).getInventory());
	}
	
	@Test
	public void testSetWinner() {
		assertEquals("test default winner.", HorseStatus.won, machine.getHorses().get(0).getIsWinner());
		assertNotEquals("test default winner.", HorseStatus.won, machine.getHorses().get(1).getIsWinner());

		machine.setWinner(2);
		assertEquals("test loosing horse in second round.", HorseStatus.lost, machine.getHorses().get(0).getIsWinner());
		assertEquals("test new winner.", HorseStatus.won, machine.getHorses().get(1).getIsWinner());
	}
	
	@Test
	public void testPayout() {
		assertEquals("count number of type of currencies", 5, machine.getNotes().length);
		assertEquals("test inventory count for a currency. " , 10, machine.getInventory().get(0).getInventory());
		assertEquals("test inventory count for a currency. " , 10, machine.getInventory().get(1).getInventory());
		assertEquals("test inventory count for a currency. " , 10, machine.getInventory().get(2).getInventory());
		assertEquals("test inventory count for a currency. " , 10, machine.getInventory().get(3).getInventory());
		assertEquals("test inventory count for a currency. " , 10, machine.getInventory().get(4).getInventory());
		
		machine.setWinner(1);
		machine.payout(1, 5);
		assertEquals("test inventory count for a currency. " , 10, machine.getInventory().get(0).getInventory());
		assertEquals("test inventory count for a currency. " , 9, machine.getInventory().get(1).getInventory());
		assertEquals("test inventory count for a currency. " , 10, machine.getInventory().get(2).getInventory());
		assertEquals("test inventory count for a currency. " , 9, machine.getInventory().get(3).getInventory());
		assertEquals("test inventory count for a currency. " , 10, machine.getInventory().get(4).getInventory());
		
		machine.setWinner(4);
		machine.payout(4, 34);
		assertEquals("test inventory count for a currency. " , 9, machine.getInventory().get(0).getInventory());
		assertEquals("test inventory count for a currency. " , 8, machine.getInventory().get(1).getInventory());
		assertEquals("test inventory count for a currency. " , 9, machine.getInventory().get(2).getInventory());
		assertEquals("test inventory count for a currency. " , 8, machine.getInventory().get(3).getInventory());
		assertEquals("test inventory count for a currency. " , 9, machine.getInventory().get(4).getInventory());
	}
	
	@Test
	public void testAddRemoveHorse() {
		assertEquals("verify number of horses.", 7, machine.getHorses().size());
		machine.addHorse("some Horse", 100);
		assertEquals("verify number of horses.", 8, machine.getHorses().size());
		machine.addHorse("some Horse", 500);
		assertEquals("verify number of horses.", 8, machine.getHorses().size());
		machine.removeHorse(8);
		assertEquals("verify number of horses.", 7, machine.getHorses().size());
	}
}
