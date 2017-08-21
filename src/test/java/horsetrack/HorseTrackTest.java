package horsetrack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

import com.racing.HorseStatus;
import com.racing.HorseTrack;

public class HorseTrackTest {

	HorseTrack horseTrack;

	@Before
	public void setup() {
		horseTrack = new HorseTrack();
	}

	@Test
	public void testMachine() {
		ByteArrayInputStream in = new ByteArrayInputStream("R 1 5 w 2 2 3 3 3 q".getBytes());
		System.setIn(in);
		horseTrack.startMachine();
		assertEquals(9, horseTrack.getMachine().getInventory().get(1).getInventory());
		assertNotEquals(HorseStatus.won, horseTrack.getMachine().getHorses().get(0).getIsWinner());
		assertEquals(HorseStatus.won, horseTrack.getMachine().getHorses().get(1).getIsWinner());
	}
	@Test
	public void test2Machine() {
		ByteArrayInputStream in = new ByteArrayInputStream("1 5 w 7 7 3 R".getBytes());
		System.setIn(in);
		horseTrack.startMachine();
		assertEquals(10, horseTrack.getMachine().getInventory().get(1).getInventory());
		assertEquals(10, horseTrack.getMachine().getInventory().get(4).getInventory());
		assertNotEquals(HorseStatus.won, horseTrack.getMachine().getHorses().get(0).getIsWinner());
		assertEquals(HorseStatus.won, horseTrack.getMachine().getHorses().get(6).getIsWinner());
	}
}
