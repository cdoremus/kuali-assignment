# Kuali Elevator Simulation Programming Assignment #

### Use the following command to run the simulation:###
```bash
./gradlew -Dtest.single=ElevatorRequestControllerTest test
```
Go to /reports/tests/classes/org.kuali.assignment.elevator.ElevatorRequestControllerTest.html
and click on the 'Standard output' button to see the reporting notifications.

###Assignment requirements with my implementation explanation (bold text):###

Design a set of objects that will manage elevator movement and interaction between the 
elevators. The elevator simulation should support these features: 
 
* Initialize the elevator simulation with the desired number of elevators, and the desired 
number of floors. Assume ground/min of one. 

**This is done in ElevatorSystemInitializer with use of ElevatorSystemConfigImpl**
 
* Each elevator will report as is moves from floor to floor.

**ElevatorRequestController.floorPassed() method as part of an implementation of ElevatorNotificationListener does this and
Reporting is done via sysout logging**
 
* Each elevator will report when it opens or closes its doors.

**ElevatorRequestControllerdoorOpens() and doorClosed() method as part of an implementation of ElevatorNotificationListener does this and 
Reporting is done via sysout logging** 
 
* An elevator cannot proceed above the top floor. 

**ElevatorValidator using ElevatorSystemConfigImpl does this**

* An elevator cannot proceed below the ground floor (assume 1 as the min). 

**ElevatorValidator using ElevatorSystemConfigImpl does this**

* An elevator request can be made at any floor, to go to any other floor.

**This is part of the system implemented in the ElevatorRequestController and ElevatorMovementService** 

* When an elevator request is made, the unoccupied elevator closest to it will answer 
the call, unless an occupied elevator is moving and will pass that floor on its way. The 
exception is that if an unoccupied elevator is already stopped at that floor, then it will 
always have the highest priority answering that call. 

**These rules are implemented in ElevatorRequestService.selectElevatorCar() using data in ElevatorCarRepository in-memory database**

* The elevator should keep track of how many trips it has made, and how many floors it 
has passed. The elevator should go into maintenance mode after 100 trips, and stop 
functioning until serviced, therefore not be available for elevator calls. 

**These rules are kept track of in the ElevatorCar object that is persisted to the in-memory database. The ElevatorMovementService updates the ElevatorCar fields (totalFloorCount and totalTrips) and checks to see if out-of-service maintenance is needed**


