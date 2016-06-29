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
	
}
