package org.kuali.assignment.elevator;

public enum ElevatorSystemConfigImpl implements ElevatorSystemConfig {
	INSTANCE;
	
	@Override
	public int getTopFloor() {
		return getTotalNumberOfFloors();
	}
	
	
	@Override
	public int getNumberOfElevators() {
		//TODO: Obtain number via DI or an external file or system property
		return 3;
	}


	@Override
	public int getTotalNumberOfFloors() {
		//TODO: Obtain number via DI or an external file or system property
		return 10;
	}


	@Override
	public int getBottomFloor() {
		//TODO: Obtain number via DI or an external file or system property
		return 1;
	}


	@Override
	public int getTripCountMaintenanceThreshold() {
		//TODO: Obtain number via DI or an external file or system property
		return 100;
	}
}
