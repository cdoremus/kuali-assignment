package org.kuali.assignment.elevator;

public interface ElevatorCarRepository {

	ElevatorCar create(ElevatorCar elevator);
	
	ElevatorCar findById(int elevatorCarId);
	
	void update(ElevatorCar elevator);
	
	/********* Elevator call rules follow **********/
	
	//1st priority
	ElevatorCar findUnoccupiedElevatorAtFloor(ElevatorCallState callState);
	
	//2nd priority
	public ElevatorCar movingOccupiedElevatorPassingCurrentFloor(ElevatorCallState callState);
	
	//3rd priority
	public ElevatorCar closestUnoccupiedElevator(ElevatorCallState callState);
	
}
