package org.kuali.assignment.elevator;

public class ElevatorUi {
	
	private ElevatorRequestController requestController;
	
	public ElevatorUi() {
		requestController = new ElevatorRequestController();
	}
	
	public void callElevator(int startFloor, int destinationFloor) {
		requestController.call(new ElevatorCallState(startFloor, destinationFloor));
	}
	
	public static void main(String[] args) {
		//initialize system
		ElevatorSystemInitializer initializer = new ElevatorSystemInitializer();
		initializer.init();
		
		//FIXME: This is not complete. The simulation can be seen by running the ElevatorRequestControllerTest test class.
		
		//TODO: There would need to be a loop here to go through simulation with N number of call requests
		//	and travels to floor destination

		//TODO: Example of the initialization of a instance of an elevator request and trip from a given start floor and destination floor  
		ElevatorUi ui = new ElevatorUi();
		ui.callElevator(1, 6);

	}

}
