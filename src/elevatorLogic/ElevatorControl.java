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
	
	public void addPassenger(){
		if(dropPassengerLocation.get(floor)<maximumPassengers){
			for(int z=0; z<dropPassengerLocation.get(floor); z++){
				dropPassengerLocation.set(randInt(0,5), dropPassengerLocation.get(floor)+1);
			}
			passengerCount++;
		}
		else
			System.out.println("Someone is trying to get on when the maximum capacity has already been reached. How should this be handled?");
	}
	
	public void removePassengers(){
		if(dropPassengerLocation.get(floor)>0){
			for(int z=0; z<dropPassengerLocation.get(floor); z++){
					dropPassengerLocation.set(z,dropPassengerLocation.get(z)-1);
					passengerCount--;
			}
		}
	}
	
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
	}

	public int getPosition(){
		return position;
	}
	
	public int getButton(){
		return lastButtonPress;
	}
	
	public int getNextFloor(){
		return nextPassengerLocation.get(lastButtonPress);
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}