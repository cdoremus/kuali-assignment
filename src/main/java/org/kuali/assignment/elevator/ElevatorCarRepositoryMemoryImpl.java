package org.kuali.assignment.elevator;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// This is an in-memory database instance, implemented as an enum.
//	An actual SQL or no-SQL database would be used in a distributed environment.
public enum ElevatorCarRepositoryMemoryImpl implements ElevatorCarRepository {

	INSTANCE;
	
	// key is ElevatorCar id
	Map<Integer,ElevatorCar> elevatorCarMap = new ConcurrentHashMap<>();
	private ElevatorSystemConfig config = ElevatorSystemConfigImpl.INSTANCE;
	
	
	public ElevatorCar create(ElevatorCar elevator) {
		elevator.setId(ElevatorCarIdRepository.INSTANCE.getNextId());
		elevatorCarMap.put(elevator.getId(), elevator);
//		System.out.println(String.format("Elevator created with id=%d", elevator.getId()));
		return elevator;
	}


	@Override
	public ElevatorCar findById(int elevatorCarId) {
		return elevatorCarMap.get(elevatorCarId);
	}



	@Override
	public void update(ElevatorCar elevator) {
		elevatorCarMap.put(elevator.getId(), elevator);
	}
	
	@Override //1st priority
	public ElevatorCar findUnoccupiedElevatorAtFloor(ElevatorCallState callState) {
		ElevatorCar car = null;
		Collection<ElevatorCar> cars = elevatorCarMap.values();
		for (ElevatorCar elevatorCar : cars) {
			if (isNotOccupiedAtFloor(elevatorCar, callState.getStartFloor())) {
				car = elevatorCar;
				break;
			}
		}
		return car;
	}

	private boolean isNotOccupiedAtFloor(ElevatorCar elevatorCar, int startFloor) {
		return (elevatorCar.isInService() && !elevatorCar.isOccupied() && elevatorCar.getCurrentFloor() == startFloor);
	}

	@Override //2nd priority
	public ElevatorCar movingOccupiedElevatorPassingCurrentFloor(ElevatorCallState callState) {
		ElevatorCar car = null;
		Collection<ElevatorCar> cars = elevatorCarMap.values();
		for (ElevatorCar elevatorCar : cars) {
			if (isOccupiedAndMovingTowardFloor(elevatorCar, callState)) {
				car = elevatorCar;
			}
		}
		return car;
	}

	private boolean isOccupiedAndMovingTowardFloor(ElevatorCar elevatorCar, ElevatorCallState callState) {
		return (elevatorCar.isInService() && elevatorCar.isOccupied() && elevatorCarPassingStartFloor(elevatorCar, callState));
	}
	
	boolean elevatorCarPassingStartFloor(ElevatorCar elevatorCar, ElevatorCallState callState) {
		return (elevatorCar.getCurrentFloor() > callState.getStartFloor()
				&& elevatorCar.getRequestedFloor() <= callState.getStartFloor()
				&& elevatorCar.getMovementDirection() == MovementDirection.DOWN)
				|| (elevatorCar.getCurrentFloor() < callState.getStartFloor() 
				&& elevatorCar.getRequestedFloor() >= callState.getStartFloor()
				&& elevatorCar.getMovementDirection() == MovementDirection.UP);
	}

	
	@Override //3rd priority
	public ElevatorCar closestUnoccupiedElevator(ElevatorCallState callState) {
		ElevatorCar car = null;
		// determine max difference
		int floorDifference = Math.abs(callState.getStartFloor() - config.getTopFloor());
		Collection<ElevatorCar> cars = elevatorCarMap.values();
		for (ElevatorCar elevatorCar : cars) {
			if (elevatorCar.isInService()) {
				int diff = Math.abs(elevatorCar.getCurrentFloor() - callState.getStartFloor());
				if (diff < floorDifference) {
					floorDifference = diff;
					car = elevatorCar;
				}
			}
		}
		
		return car;
	}

	
}
