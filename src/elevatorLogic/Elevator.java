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
	}
	
	public void getIfOnFloor(){
		if(position%120==0){
			removePassenger();
			floor=position%300;
			setVelocity(0);
			getNextPassenger();
		}
		floor=position/120;
	}
	
	
	public void addRandom(){
		if(randInt(0,20)>18)
			nextPassengerLocation.add(randInt(0, 5));
	}
}
