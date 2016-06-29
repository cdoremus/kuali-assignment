package org.kuali.assignment.elevator;

public class ElevatorSystemInitializer {

	private ElevatorSystemConfig config;
	
	public ElevatorSystemInitializer() {
		// A DI framework like Spring or Guice should be used 
		config = ElevatorSystemConfigImpl.INSTANCE;
	}

	public void init() {

	}
	
	
	
}
