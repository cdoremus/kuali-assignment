package org.kuali.assignment.elevator;

public interface ElevatorNotificationListener {
	void floorPassed(ElevatorCar elevator);
	void doorOpens(ElevatorCar elevator);
	void doorCloses(ElevatorCar elevator);
}
