package org.kuali.assignment.elevator;

public interface ElevatorCarRepository {

	ElevatorCar create(ElevatorCar elevator);
	
	ElevatorCar findById(int elevatorCarId);
	
	void update(ElevatorCar elevator);
	
}
