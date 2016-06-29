package org.kuali.assignment.elevator;

public class ElevatorCallState {
	private final int startFloor;
	private final int requestedFloor;
	
	public ElevatorCallState(int startFloor, int requestedFloor) {
		this.startFloor = startFloor;
		this.requestedFloor = requestedFloor;
	}

	public int getStartFloor() {
		return startFloor;
	}

	public int getRequestedFloor() {
		return requestedFloor;
	}
	
}
