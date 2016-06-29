package org.kuali.assignment.elevator;

public class ElevatorMovementService {
	private ElevatorNotificationListener elevatorNotificationListener;
	
	public ElevatorMovementService(ElevatorNotificationListener elevatorNotificationListener) {
		this.elevatorNotificationListener = elevatorNotificationListener;
	}

	public void moveToDestination(ElevatorCar elevator) {
		//elevator arrives at start floor and door opens
		elevatorNotificationListener.doorOpens(elevator);
		//Door closes at start floor
		elevatorNotificationListener.doorCloses(elevator);
		int currentFloor = elevator.getCurrentFloor();
		int destinationFloor = elevator.getRequestedFloor();
		int difference = Math.abs(currentFloor - destinationFloor);
		//elevator moves through the floors toward its destination
		while(difference != 0) {
			singleMove(elevator);
			difference--;
		}
		//elevator arrives and door opens
		elevatorNotificationListener.doorOpens(elevator);
		
		//Passenger(s), exit the elevator and new passenger(s) enter the elevator
		
		//Door closes
		elevatorNotificationListener.doorCloses(elevator);
		
		//increment totalTrips
		int totalTrips = elevator.getTotalTrips();
		elevator.setTotalTrips(++totalTrips);
	}

	public ElevatorCar singleMove(ElevatorCar elevator) {
		
		int currentFloor = elevator.getCurrentFloor();
		int destinationFloor = elevator.getRequestedFloor();
		
		// move to the next floor
		if (currentFloor != destinationFloor) {
			//TODO: Make sure we are not going beyond the top or bottom floor
			
			switch (elevator.getMovementDirection()) {
				case UP:
					elevator.setCurrentFloor(++currentFloor);
					break;
				case DOWN:
					elevator.setCurrentFloor(--currentFloor);
					break;
				default:
					break;
			}
			//notify that a floor has passed
			elevatorNotificationListener.floorPassed(elevator);
			//increment totalFloorCount
			int totalFloorCount = elevator.getTotalFloorCount();
			elevator.setTotalFloorCount(totalFloorCount++);
		}
		
		return elevator;
	}
}
