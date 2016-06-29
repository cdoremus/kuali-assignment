package org.kuali.assignment.elevator;

public interface ElevatorDoorListener {
	void doorOpens(ElevatorCar elevator);
	void doorCloses(ElevatorCar elevator);
}
