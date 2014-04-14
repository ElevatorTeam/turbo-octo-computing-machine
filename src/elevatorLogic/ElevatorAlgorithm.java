package elevatorLogic;

import java.util.ArrayList;

public class ElevatorAlgorithm extends ElevatorPassengers{
	
	int prevdirection;	
	//this is the class that controls the direction the elevator is going.
	//runAlgorithm shall be the function that STARTS the algoritm on finding which way the elevator should go.
	public void runAlgorithm(){
		if(destination==floor){
			setDestination();
			setVelocity(0);
		}
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
		if(waitCount>0){
			setVelocity(0);
			--waitCount;
		}
		//System.out.println("destination: " + destination + "floor: " + floor);
	}
	
	public void setDestination(){
	/*	destination = floor;	
		if(analyzeWaiters()!=-1)
			destination=analyzeWaiters();	
		if(analyzePassengers()!=-1)
			destination=analyzePassengers();	
	 */
		int i = 0; //lowest floor for dropping off
		int x = 0; //highest floor for dropping off
		int g = 0; //lowest floor for picking up
		int z = 0; //highest floor for picking up	
		for(i = 0; i<dropPassengerLocation.size()-1 && dropPassengerLocation.get(i) == 0; i++);//lowest level with dropoff requests 
		//System.out.println("dropoffmin: " + i);
		for(x = dropPassengerLocation.size()-1; x>0 && dropPassengerLocation.get(x) == 0; x--);//highest level with dropoff requests	
		//System.out.println("dropoffmax: " + x);	
		for(g = 0; g<nextPassengerLocation.size()-1 && nextPassengerLocation.get(g) == 0; g++);//lowest level that has pickup requests.
		//System.out.println("pickupmin: " + g);	
		for(z = nextPassengerLocation.size()-1; z>0 && nextPassengerLocation.get(z) == 0; z--);//highest level with pickup requests
		//System.out.println("pickupmax: " + z);	
		
		if(prevdirection == 1)//going up
		{
			//System.out.println(dropPassengerLocation.get(x));	
			if(destination<=x && dropPassengerLocation.get(x) > 0  && x!=floor)
			{
				destination = x;
				//System.out.println("1 passenger up to floor:" + destination);
				return;
			}
			if(nextPassengerLocation.get(z) > 0  && z!=floor)
			{
				destination = z;
				//System.out.println("1 People up to floor:" + destination);
				return;
			}	
			if(dropPassengerLocation.get(i) > 0  && i!=floor)
			{
				destination = i;
				//System.out.println("1 passenger down to floor:" + destination);
				return;
			}
			if(nextPassengerLocation.get(g) > 0  && g!=floor)
			{
				destination = g;
				//System.out.println("1 people down to floor:" + destination);
				return;
			}
			//System.out.println(getPeopleList() + getPassengerList() + "destination:" + destination);
			return;	
		}
		
		if(prevdirection == -1)//going down
		{
			if(destination>=i && dropPassengerLocation.get(i) > 0 && i!=floor)
			{
				destination = i;	
				//System.out.println("2 passenger down to floor:" + destination);
				return;	
			}
			if(nextPassengerLocation.get(g) > 0 && g!=floor)
			{
				destination = g;
				//System.out.println("2 people down to floor:" + destination); 
				return;
			}	
			if(dropPassengerLocation.get(x) > 0  && x!=floor)
			{
				destination = x;
				//System.out.println("2 passenger up to floor:" + destination);
				return;
			}
			if(nextPassengerLocation.get(z) > 0 && z!=floor)
			{
				destination = g;
				//System.out.println("2 People up to floor:" + destination);
				return;
			}	
			//System.out.println(getPeopleList() + getPassengerList() + "destination:" + destination);
			return;	
		}
	}
/*
	public int analyzePassengers()
	{		
		int i,x;		
		for(i = 0; i<dropPassengerLocation.size() | dropPassengerLocation.get(i) == 0; i++);//i lowest requested floor
		for(x = dropPassengerLocation.size(); x>0 | dropPassengerLocation.get(i) == 0; x--);//x is highest requested floor		
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
*/
}
