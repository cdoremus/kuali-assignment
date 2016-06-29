package org.kuali.assignment.elevator;

public class ElevatorRequestController implements ElevatorNotificationListener {
	private ElevatorMovementService elevatorMovementService;
	private ElevatorRequestService elevatorRequestService;
	private ElevatorMaintenanceService  elevatorMaintenanceService;
	
	public ElevatorRequestController() {
		//TODO: Use DI to inject these
		this.elevatorMovementService = new ElevatorMovementService(this);
		this.elevatorRequestService = new ElevatorRequestService();
		this.elevatorMaintenanceService = new ElevatorMaintenanceService();
	}
	
	//Use this for manual DI in tests
	ElevatorRequestController(ElevatorMovementService elevatorMovementController, 
			ElevatorRequestService elevatorRequestService, ElevatorMaintenanceService  elevatorMaintenanceService) {
		this.elevatorMovementService = elevatorMovementController;
		this.elevatorRequestService = elevatorRequestService;
		this.elevatorMaintenanceService = elevatorMaintenanceService;
	}

	/**
	 * Fulfill an single elevator request and travel to the destination floor
	 * 
	 * @param callState contains the start and destination floors
	 * @return the id of the travelled car
	 */
	public int call(ElevatorCallState callState) {
		
		//car selected
		ElevatorCar selectedCar = null;
		try {
			selectedCar = elevatorRequestService.selectElevatorCar(callState);
			selectedCar.setCurrentFloor(callState.getStartFloor());
			selectedCar.setRequestedFloor(callState.getRequestedFloor());
			selectedCar.setMovementDirection(callState.getMovementDirection());
			
		} catch (ElevatorValidationException e) {
			// TODO Auto-generated catch block
			System.err.println(String.format("Validation problem: %s", e.getMessage()));
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.err.println(String.format("Runtime exception: %s", e.getMessage()));
			
			e.printStackTrace();
		}
		
		return selectedCar != null ? selectedCar.getId() : 0;
	}

	
	
	@Override
	public void doorOpens(ElevatorCar elevator) {
		// TODO: Notify UI or another reporting mechanism to indicate that door has opened.
		//	This will require a reference to the UI, so we can populate notification controls.
		
		// For now we will just print out the door opening notification to stdout
		System.out.printf("Elevator %s door has opened on floor %s\n", elevator.getId(), elevator.getCurrentFloor());
		
	}

	@Override
	public void doorCloses(ElevatorCar elevator) {
		// TODO: Notify UI or another reporting mechanism to indicate that door has opened. 
		//	This will require a reference to the UI, so we can populate notification controls.
		
		// For now we will just print out the door closing notification to stdout
		System.out.printf("Elevator %s door has closed on floor %s\n", elevator.getId(), elevator.getCurrentFloor());
		
	}

	@Override
	public void floorPassed(ElevatorCar elevator) {
		// TODO: Notify UI or another reporting mechanism to indicate that a new floor has passed.
		//	This will require a reference to the UI, so we can populate notification controls.
		
		// For now we will just print out the floor passed notification to stdout
		System.out.printf("Elevator %s has just passed floor %s\n", elevator.getId(), elevator.getCurrentFloor());
	}
}
