package org.kuali.assignment.elevator;

public class ElevatorPassenger {

	private final int startFloor;
	private final int destinationFloor;
	
	public ElevatorPassenger(int startFloor, int destinationFloor) {
		this.startFloor = startFloor;
		this.destinationFloor = destinationFloor;
	}

	public int getStartFloor() {
		return startFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}
}
