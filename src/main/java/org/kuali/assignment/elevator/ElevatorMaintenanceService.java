package org.kuali.assignment.elevator;

public class ElevatorMaintenanceService {

	ElevatorSystemConfig config;
	
	public ElevatorMaintenanceService() {
		//TODO: DI this
		config = ElevatorSystemConfigImpl.INSTANCE;
	}
	
	
	public void maintenanceCheck(ElevatorCar elevatorCar) {
	
	}
}
