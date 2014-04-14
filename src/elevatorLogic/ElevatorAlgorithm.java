package elevatorLogic;

import java.util.ArrayList;

public class ElevatorAlgorithm extends ElevatorPassengers{
	
	//this is the class that controls the direction the elevator is going.
	//runAlgorithm shall be the function that STARTS the algoritm on finding which way the elevator should go.
	public void runAlgorithm(){
		if(destination>floor)
			setVelocity(1);
		if(destination<floor)
			setVelocity(-1);
		if(position<-1)
			setVelocity(1);
	}
}