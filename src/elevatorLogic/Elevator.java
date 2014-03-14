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
		thisFloorChecked=false;
	}
	
	public void getIfOnFloor(){
		if(position%120==0){
			floor=position%120;
			removePassengers();
			pickUpPassengers();
			if(floor==lastButtonPress)
				runAlgorithm();
		}
	}
	
	public void addRandom(){
		if(randInt(0,20)>18){
			chosenFloor= nextPassengerLocation.get(randInt(0, 5));
			nextPassengerLocation.set(chosenFloor,chosenFloor+1);
			if(floor==lastButtonPress)
				lastButtonPress=chosenFloor;
		}
	}
}
