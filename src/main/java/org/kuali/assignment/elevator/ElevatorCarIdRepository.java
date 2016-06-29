package org.kuali.assignment.elevator;

import java.util.concurrent.atomic.AtomicInteger;

//We are assuming here that the system exists in a single JVM instance so that this singleton instance
//	will always return a unique id when getNextId() is called.
// In a distributed system, a database sequence or other centrally located id thread-safe repository 
//	be used instead. 
public enum ElevatorCarIdRepository {
	
	INSTANCE;
	
	private AtomicInteger idGenerator = new AtomicInteger(0);
	
	public int getNextId() {
		return idGenerator.incrementAndGet();
	}

	public void reset() {
		idGenerator.set(0);
	}
}
