package org.kuali.assignment.elevator;

public class ElevatorCar {

	private int id;
	private int currentFloor = 1;
	private int requestedFloor = 1;
	private boolean isOccupied;
	private boolean isInService = true;
	private int totalFloorCount;
	private int totalTrips;
	private MovementDirection movementDirection = MovementDirection.NOT_MOVING;

	public ElevatorCar() {
	}

	// TODO: Static copy constructor

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public int getRequestedFloor() {
		return requestedFloor;
	}

	public void setRequestedFloor(int requestedFloor) {
		this.requestedFloor = requestedFloor;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public boolean isInService() {
		return isInService;
	}

	public void setInService(boolean isInService) {
		this.isInService = isInService;
	}

	public int getTotalFloorCount() {
		return totalFloorCount;
	}

	public void setTotalFloorCount(int totalFloorCount) {
		this.totalFloorCount = totalFloorCount;
	}

	public int getTotalTrips() {
		return totalTrips;
	}

	public void setTotalTrips(int totalTrips) {
		this.totalTrips = totalTrips;
	}

	public MovementDirection getMovementDirection() {
		return movementDirection;
	}

	public void setMovementDirection(MovementDirection movementDirection) {
		this.movementDirection = movementDirection;
	}

}
