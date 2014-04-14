package elevatorLogic;

import java.util.ArrayList;

public class ElevatorAlgorithm extends ElevatorPassengers{
	
	int prevdirection;	
	//this is the class that controls the direction the elevator is going.
	//runAlgorithm shall be the function that STARTS the algoritm on finding which way the elevator should go.
	public void runAlgorithm(){
		if(destination==floor)
			setVelocity(0);
		if(destination>floor)
		{	
			setVelocity(1);
			prevdirection = 1;	
		}
		if(destination<floor)
		{
			setVelocity(-1);
			prevdirection = -1;	
		}	
		System.out.println("destination: " + destination + "floor: " + floor);
	}
	
	public void setDestination(){
		if(analyzeWaiters()!=-1)
			destination=analyzeWaiters();	
		if(analyzePassengers()!=-1)
			destination=analyzePassengers();	
		destination=floor;
	}
	
	public int analyzePassengers()
	{		
		int i;
		if(prevdirection == 1)	
			for(i = 0; i<dropPassengerLocation.size() | dropPassengerLocation.get(i) == 0; i++);//if the elevator was going up before this function, look for the lowest floor to requested
		if(prevdirection == -1)	
			for(i = dropPassengerLocation.size(); i>0 | dropPassengerLocation.get(i) == 0; i--);//if the elevator was going down before this function, look for the highest floor requested	
		
		if(dropPassengerLocation.get(i) > 0)	
			return i;		
		return -1;
	}
	
	public int analyzeWaiters()//called if there is nobody in elevator. for loops operate the same way as they do in the analyzePassengers, but for requests from floors.
	{
		int i;
		if(prevdirection == 1)	
			for(i = 0; i<nextPassengerLocation.size() | nextPassengerLocation.get(i) == 0; i++);
		if(prevdirection == -1)	
			for(i = nextPassengerLocation.size(); i>0 | nextPassengerLocation.get(i) == 0; i--);	
		
		if(nextPassengerLocation.get(i) > 0)	
			return i;	
		return -1;
	}
}
