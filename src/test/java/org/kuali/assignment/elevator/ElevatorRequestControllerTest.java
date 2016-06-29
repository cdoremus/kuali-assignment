package org.kuali.assignment.elevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElevatorRequestControllerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//reset id generator for each test
		ElevatorCarIdRepository.INSTANCE.reset();
		//initialize system including repository
		ElevatorSystemInitializer systemInitializer = new ElevatorSystemInitializer();
		systemInitializer.init();
		
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testCall_SingleCall() {
//		ElevatorRequestController requestController = new ElevatorRequestController();
//
//		int id = requestController.call(new ElevatorCallState(1, 5));
//		
//		assertTrue(id != 0);
//	}

	@Test
	public void testCall_MultiplesSimultaneousCalls() {
		ElevatorRequestController requestController1 = new ElevatorRequestController();
		int id1 = requestController1.call(new ElevatorCallState(1, 5));
		assertTrue(id1 != 0);

		ElevatorRequestController requestController2 = new ElevatorRequestController();
		int id2 = requestController2.call(new ElevatorCallState(6, 4));
		assertTrue(id2 != 0);

		ElevatorRequestController requestController3 = new ElevatorRequestController();
		int id3 = requestController3.call(new ElevatorCallState(1, 2));
		assertTrue(id3 != 0);

	
		ElevatorRequestController requestController4 = new ElevatorRequestController();
		int id4 = requestController4.call(new ElevatorCallState(1, 9));
		assertTrue(id4 != 0);
	}

}
