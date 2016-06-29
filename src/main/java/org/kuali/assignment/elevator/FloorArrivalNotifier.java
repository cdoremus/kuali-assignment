package org.kuali.assignment.elevator;

import java.util.Set;
import java.util.TreeSet;

public class FloorArrivalNotifier {

	Set<ElevatorNotificationListener> notificationListenerSet;
	
	public FloorArrivalNotifier() {
		notificationListenerSet = new TreeSet<>();
	}
	
	public void add(ElevatorNotificationListener notificationListener) {
		notificationListenerSet.add(notificationListener);
	}
	
}
