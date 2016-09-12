package org.kuali.assignment.elevator;

public class ElevatorRequestService {

	private ElevatorValidator elevatorValidator;
	private ElevatorCarRepository carRepository;
	
	
	public ElevatorRequestService() {
		//TODO: Use DI instead
		elevatorValidator = new ElevatorValidator();
		carRepository = ElevatorCarRepositoryMemoryImpl.INSTANCE;
	}

	public ElevatorRequestService(ElevatorCarRepository carRepository, ElevatorValidator elevatorValidator) {
		this.carRepository = carRepository;
		this.elevatorValidator = elevatorValidator;
	}
	
	
	public ElevatorCar selectElevatorCar(ElevatorCallState callState) throws ElevatorValidationException {
		ElevatorCar car = null;
		if (!elevatorValidator.validateFloorSelection(callState)) {
			throw new ElevatorValidationException(String.format("Starting floor or requested floor is not valid (start floor=%d, requested floor=%d", callState.getStartFloor(), callState.getRequestedFloor()));
		}
		synchronized (this) {			
			//1st priority
			car = carRepository.findUnoccupiedElevatorAtFloor(callState);
			//2nd priority
			if (car == null) {
				car = carRepository.movingOccupiedElevatorPassingCurrentFloor(callState);
			}
			//3rd priority
			if (car == null) {
				car = carRepository.closestUnoccupiedElevator(callState);
			}
		}
		
		// If car is still null at this point, an exception should be thrown
		if (car == null) {
			throw new IllegalStateException(String.format("An elevator car has not been found using the call state: %s", callState.toString()));
		}
		return car;		
	}		

	public void updateElevator(ElevatorCar elevator) {
		
		//persist elevator
		carRepository.update(elevator);
	}
}
