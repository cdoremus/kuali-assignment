package org.kuali.assignment.elevator;

//FIXME: THis needs to be implemented to encapsulate maintenance functions
public class ElevatorMaintenanceService {

	ElevatorSystemConfig config;
	
	public ElevatorMaintenanceService() {
		//TODO: DI this
		config = ElevatorSystemConfigImpl.INSTANCE;
	}
	
	
	public void maintenanceCheck(ElevatorCar elevatorCar) {
	
	}
}
