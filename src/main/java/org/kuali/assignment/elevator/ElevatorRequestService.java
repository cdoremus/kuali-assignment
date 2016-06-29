package org.kuali.assignment.elevator;

public class ElevatorRequestService {

	private ElevatorValidator elevatorValidator;
	
	
	public ElevatorRequestService() {
		//TODO: Use DI instead
		elevatorValidator = new ElevatorValidator();
	}

	public ElevatorRequestService(ElevatorValidator elevatorValidator) {
		this.elevatorValidator = elevatorValidator;
	}
	
	
	public ElevatorCar selectElevatorCar(ElevatorCallState callState) throws ElevatorValidationException {
		ElevatorCar car = null;
		if (!elevatorValidator.validateFloorSelection(callState)) {
			throw new ElevatorValidationException(String.format("Starting floor or requested floor is not valid (start floor=%d, requested floor=%d", callState.getStartFloor(), callState.getRequestedFloor()));
		}
		
		
		return car;
	}		
}
