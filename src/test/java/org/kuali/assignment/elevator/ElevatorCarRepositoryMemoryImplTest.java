package org.kuali.assignment.elevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElevatorCarRepositoryMemoryImplTest {

	private ElevatorCarRepositoryMemoryImpl repository;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ElevatorCarIdRepository.INSTANCE.reset();
		repository = ElevatorCarRepositoryMemoryImpl.INSTANCE;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAndFindById() throws Exception {
		ElevatorCar elevator = new ElevatorCar();
		
		ElevatorCar newCar = repository.create(elevator);
		assertTrue(newCar.getId() != 0);
		
		ElevatorCar found = repository.findById(newCar.getId());
		
		assertSame(found, newCar);
	}
	
	@Test
	public void testElevatorCarMovingDownAndPassingStartFloor_PassingStart() {
		
		ElevatorCar elevatorCar = new ElevatorCar();
		elevatorCar.setCurrentFloor(7);
		elevatorCar.setRequestedFloor(4);
		elevatorCar.setOccupied(true);
		elevatorCar.setMovementDirection(MovementDirection.DOWN);
		
		boolean ok = repository.elevatorCarPassingStartFloor(elevatorCar, new ElevatorCallState(5, 3));
		
		assertTrue(ok);
		
	}

	@Test
	public void testElevatorCarMovingDownAndPassingStartFloor_NotPassingStart() {
		
		ElevatorCar elevatorCar = new ElevatorCar();
		elevatorCar.setCurrentFloor(7);
		elevatorCar.setRequestedFloor(6);
		elevatorCar.setOccupied(true);
		elevatorCar.setMovementDirection(MovementDirection.DOWN);
		
		boolean ok = repository.elevatorCarPassingStartFloor(elevatorCar, new ElevatorCallState(5, 3));
		
		assertFalse(ok);
		
	}

	@Test
	public void testElevatorCarMovingUpAndPassingStartFloor_PassingStart() {
		
		ElevatorCar elevatorCar = new ElevatorCar();
		elevatorCar.setCurrentFloor(4);
		elevatorCar.setRequestedFloor(7);
		elevatorCar.setOccupied(true);
		elevatorCar.setMovementDirection(MovementDirection.UP);
		
		boolean ok = repository.elevatorCarPassingStartFloor(elevatorCar, new ElevatorCallState(5, 3));
		
		assertTrue(ok);
		
	}

	@Test
	public void testElevatorCarMovingUpAndPassingStartFloor_NotPassingStart() {
		
		ElevatorCar elevatorCar = new ElevatorCar();
		elevatorCar.setCurrentFloor(6);
		elevatorCar.setRequestedFloor(7);
		elevatorCar.setOccupied(true);
		elevatorCar.setMovementDirection(MovementDirection.UP);
		
		boolean ok = repository.elevatorCarPassingStartFloor(elevatorCar, new ElevatorCallState(5, 3));
		
		assertFalse(ok);
		
	}
}
