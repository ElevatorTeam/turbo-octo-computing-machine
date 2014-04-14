package elevatorLogic;

import java.util.ArrayList;

public class ElevatorAlgorithm extends ElevatorPassengers{
	
	//this is the class that controls the direction the elevator is going.
	//runAlgorithm shall be the function that STARTS the algoritm on finding which way the elevator should go.
	public void runAlgorithm(){
		if(destination==floor)
			setVelocity(0);
		if(destination>floor)
			setVelocity(1);
		if(destination<floor)
			setVelocity(-1);
		System.out.println("destination: " + destination + "floor: " + floor);
	}
	
	public void setDestination(){
		if(analyzePassengers()!=-1)
			destination=analyzePassengers();
		if(analyzeWaiters()!=-1)
			destination=analyzeWaiters();
		destination=floor;
	}
	
	public int analyzePassengers(){
		return -1;
	}
	
	public int analyzeWaiters(){
		return -1;
	}
}