package org.kuali.assignment.elevator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElevatorRequestServiceTest {

	private ElevatorRequestService requestService;
	private ElevatorCarRepositoryMemoryImpl carRepository;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		requestService = new ElevatorRequestService();
		//reset id generator for each test
		ElevatorCarIdRepository.INSTANCE.reset();
		//initialize system including repository
		ElevatorSystemInitializer systemInitializer = new ElevatorSystemInitializer();
		systemInitializer.init();
		carRepository = ElevatorCarRepositoryMemoryImpl.INSTANCE;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectElevatorCar_closestUnoccupiedElevator() throws Exception {
		//setup cars on different floors
		ElevatorCar car2 = carRepository.findById(2);
		car2.setCurrentFloor(5);
		System.out.println("Car 2: " + car2);
		
		ElevatorCar car = requestService.selectElevatorCar(new ElevatorCallState(4, 6)); 
		
		assertEquals(car2, car);
	}


	@Test
	public void testSelectElevatorCar_findUnoccupiedElevatorAtFloor() throws Exception {
		//setup cars on different floors
		ElevatorCar car2 = carRepository.findById(2);
		car2.setCurrentFloor(4);
//		System.out.println("Car 2: " + car2);
		ElevatorCar car3 = carRepository.findById(3);
		car3.setCurrentFloor(2);
		car3.setRequestedFloor(8);
		car3.setOccupied(true);
		car3.setMovementDirection(MovementDirection.UP);
//		System.out.println("Car 3: " + car3);
		
		ElevatorCar car = requestService.selectElevatorCar(new ElevatorCallState(4, 6)); 
		
		assertEquals(car2, car);
	}
	
	@Test
	public void testSelectElevatorCar_movingOccupiedElevatorPassingCurrentFloor() throws Exception {
		//setup cars on different floors
		ElevatorCar car2 = carRepository.findById(2);
		car2.setCurrentFloor(5);
//		System.out.println("Car 2: " + car2);
		ElevatorCar car3 = carRepository.findById(3);
		car3.setCurrentFloor(2);
		car3.setRequestedFloor(8);
		car3.setOccupied(true);
		car3.setMovementDirection(MovementDirection.UP);
		System.out.println("Car 3: " + car3);
		
		ElevatorCar car = requestService.selectElevatorCar(new ElevatorCallState(4, 6)); 
		
		assertEquals(car3, car);
	}
	
	@Test
	public void testUpdateElevator() {
		ElevatorCar elevatorCar = new ElevatorCar();
		elevatorCar.setId(2);
		elevatorCar.setTotalFloorCount(20);
		
		carRepository.update(elevatorCar);
		
		ElevatorCar car = carRepository.findById(2);
		assertEquals(20, car.getTotalFloorCount());
	}

}
