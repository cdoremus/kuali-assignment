package org.kuali.assignment.elevator;

public class ElevatorMovementService {
	private ElevatorNotificationListener elevatorNotificationListener;
	
	public ElevatorMovementService(ElevatorNotificationListener elevatorNotificationListener) {
		this.elevatorNotificationListener = elevatorNotificationListener;
	}

	public void move(ElevatorCallState callState) {
		
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
