package org.kuali.assignment.elevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * TODO: Implement tests. They are commented out now so the build does not fail.
 *
 */
public class ElevatorIntegrationTest {
	private ElevatorSystemConfig config;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		config = ElevatorSystemConfigImpl.INSTANCE;
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void hasInitializedWithNumberOfFloors() {
//		//System.out.println(String.format("bottom floor=%d, top floor=%d", config.getBottomFloor(), config.getTopFloor()));
//		// Req 1
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void hasInitializedWithNumberOfElevators() throws Exception {
//		// Req 1
//		fail("Not yet implemented");		
//	}
//	
//	@Test
//	public void hasReportedFloorToFloorMovement() throws Exception {
//		// Req 2
//		fail("Not yet implemented");		
//	}
//	
//	@Test
//	public void hasReportedDoorOpening() throws Exception {
//		// Req 3
//		fail("Not yet implemented");		
//	}
//	
//	@Test
//	public void hasReportedDoorClosing() throws Exception {
//		// Req 3
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void cannotProceedAboveTopFloor() throws Exception {
//		// Req 4
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void cannotProceedBelowBottomFloor() throws Exception {
//		// Req 5
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void elevatorRequestCanBeMadeToGoToAnotherFloor() throws Exception {
//		// Req 6
//		fail("Not yet implemented");
//	}
//
//	
//	@Test
//	public void elevatorRequestCannotBeMadeToGoToTheSameFloor() throws Exception {
//		// Req 6
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void unoccupiedElevatorWillAlwaysAnswerACallFromItsCurrentFloor() throws Exception {
//		// Req 7
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void movingOccupiedElevatorWillAlwaysAnswerACallIfItIsMovingTowardThatFloor() throws Exception {
//		// Req 7
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void unoccupiedClosestElevatorWillAlwaysAnswerACall() throws Exception {
//		// Req 7
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void numberOfTripsNeedsToBeTracked() throws Exception {
//		// Req 8
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void numberOfFloorsPassedNeedsToBeTracked() throws Exception {
//		// Req 8
//		fail("Not yet implemented");
//	}
}
