package org.kuali.assignment.elevator;

public class ElevatorSystemInitializer {

	private ElevatorSystemConfig config;
	private ElevatorCarRepository carRepository;
	
	public ElevatorSystemInitializer() {
		// A DI framework like Spring or Guice should be used 
		config = ElevatorSystemConfigImpl.INSTANCE;
		carRepository = ElevatorCarRepositoryMemoryImpl.INSTANCE;
	}

	public void init() {
		// create all elevators and put them in the repository
		int numberOfCars = config.getNumberOfElevators();
		while (numberOfCars != 0) {
			ElevatorCar elevator = new ElevatorCar();
			carRepository.create(elevator);
			numberOfCars--;
		}
	}
	
	
	
}
