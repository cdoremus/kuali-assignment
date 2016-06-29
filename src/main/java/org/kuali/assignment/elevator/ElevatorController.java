package org.kuali.assignment.elevator;

public class ElevatorController {
	ElevatorMovementController elevatorMovementController;
	
	public void call(ElevatorCallState callState) {
		
		
		ElevatorCar elevator = new ElevatorCar();
		
		elevatorMovementController.move(callState);
		
	}
}
