package org.kuali.assignment.elevator;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ElevatorRequestServiceMockTest {

	private ElevatorRequestService service;
	private ElevatorCarRepository repository;
	private ElevatorValidator elevatorValidator;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		repository = mock(ElevatorCarRepository.class);
		elevatorValidator = mock(ElevatorValidator.class);
		service = new ElevatorRequestService(repository, elevatorValidator);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectElevatorCar_ElevatorCarNotFound_ThrowsException() throws Exception {
		final int startFloor = 1;
		final int endFloor = 8;
	    final String error = String.format("Starting floor or requested floor is not valid (start floor=%d, requested floor=%d", startFloor, endFloor);
		try {
			when(repository.closestUnoccupiedElevator(any(ElevatorCallState.class))).thenReturn(null);
			when(repository.movingOccupiedElevatorPassingCurrentFloor(any(ElevatorCallState.class))).thenReturn(null);
			when(repository.findUnoccupiedElevatorAtFloor(any(ElevatorCallState.class))).thenReturn(null);
		
			service.selectElevatorCar(new ElevatorCallState(startFloor, endFloor));
			fail("Should not get here");
		} catch (ElevatorValidationException e) {
			assertEquals(error, e.getMessage());
		}
		
	}

	@Test
	public void testUpdateElevator() {	
		ElevatorCar car = new ElevatorCar();
		
		service.updateElevator(car);
		
		// verify that update was called on the car repository with the car argument
		verify(repository).update(car);
		
	}

}


