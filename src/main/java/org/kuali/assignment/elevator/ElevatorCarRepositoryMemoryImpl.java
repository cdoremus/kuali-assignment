package org.kuali.assignment.elevator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// This is an in-memory database instance, implemented as an enum.
//	An actual SQL or no-SQL database would be used in a distributed environment.
public enum ElevatorCarRepositoryMemoryImpl implements ElevatorCarRepository {

	INSTANCE;
	
	// key is ElevatorCar id
	Map<Integer,ElevatorCar> elevatorCarMap = new ConcurrentHashMap<>();
	
	
	public ElevatorCar create(ElevatorCar elevator) {
		elevator.setId(ElevatorCarIdRepository.INSTANCE.getNextId());
		elevatorCarMap.put(elevator.getId(), elevator);
//		System.out.println(String.format("Elevator created with id=%d", elevator.getId()));
		return elevator;
	}


	@Override
	public ElevatorCar findById(int elevatorCarId) {
		return elevatorCarMap.get(elevatorCarId);
	}



	@Override
	public void update(ElevatorCar elevator) {
		elevatorCarMap.put(elevator.getId(), elevator);
	}
	
	
}
