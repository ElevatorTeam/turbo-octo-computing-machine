package elevatorLogic;

import java.util.ArrayList;
import java.util.Random;

public class Elevator extends ElevatorAlgorithm {

	//This package will be for creating and controlling what the elevators are doing, and NOTHING ELSE.
	//please don't put anything but the elevator object, and the code that controls it, in this project.
	
	public Elevator(){
		floor = 0;
		velocity = 0;
		passengerCount=0;
		maximumPassengers=10;
		position=0;
		for(int k = 0; k<6;k++){
			nextPassengerLocation.add(0);
			dropPassengerLocation.add(0);
		}
	}
	
	public boolean ifOnFloor(){
		if(position%120==0)
			return true;
		return false;
	}
	
	public void setNewFloor(){
		floor=position/120;
	}
	
	public void chooseNextFloor(){
		getNextFloor();
	}
	
	public boolean reachedDestination(){
		if(floor==lastButtonPress)
			return true;
		return false;
	}
	
	public void addRandom(){
		if(randInt(0,20)>2){
			chosenFloor= randInt(0, 5);
			nextPassengerLocation.set(chosenFloor,chosenFloor+1);
			lastButtonPress=chosenFloor;
		}
	}
}
