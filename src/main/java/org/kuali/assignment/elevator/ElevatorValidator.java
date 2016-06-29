package org.kuali.assignment.elevator;

public class ElevatorValidator {
	private ElevatorSystemConfig config;
	
	public ElevatorValidator() {
		//TODO: DI this
		config = ElevatorSystemConfigImpl.INSTANCE;
	}
	
	
	public boolean validateFloorSelection(ElevatorCallState callState) {
			return false;
	}
}
