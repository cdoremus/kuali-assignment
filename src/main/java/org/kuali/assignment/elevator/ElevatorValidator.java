package org.kuali.assignment.elevator;

public class ElevatorValidator {
	private ElevatorSystemConfig config;
	
	public ElevatorValidator() {
		//TODO: DI this
		config = ElevatorSystemConfigImpl.INSTANCE;
	}
	
	
	public boolean validateFloorSelection(ElevatorCallState callState) {
		if (callState.getStartFloor() < config.getBottomFloor() || 
				callState.getRequestedFloor() > config.getTopFloor()) {
			return false; 
		} else {
			return true;
		}
	}
}
