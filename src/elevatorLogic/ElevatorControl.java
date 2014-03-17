package elevatorLogic;

import java.util.ArrayList;
import java.util.Random;

public class ElevatorControl {
	
	int floor;
	int velocity;
	int passengerCount;
	int maximumPassengers;
	int position;
	public int lastButtonPress = 0;
	int chosenFloor;
	ArrayList<Integer> nextPassengerLocation = new ArrayList<Integer>();
	ArrayList<Integer> dropPassengerLocation = new ArrayList<Integer>();
	
	public void setFloor(int newFloor){
		floor=newFloor;
	}

	public void setVelocity(int newVel){
		velocity=newVel;
	}

	public int getFloor(){
		return floor;
	}

	public int getVelocity(){
		return velocity;
	}

	public int getPassengerCount(){
		return passengerCount;
	}

	public boolean ElevatorIsFull(){
		return(maximumPassengers==passengerCount);
	}

	public void setPosition(){
		position+=velocity;
		if(position>600)
			position=600;
	}

	public int getPosition(){
		return position;
	}
	
	public int getNextFloor(){
		return lastButtonPress;
	}
	
	public boolean atTopOrButtom(){
		if(floor==0 || floor==5)
			return true;
		return false;
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}