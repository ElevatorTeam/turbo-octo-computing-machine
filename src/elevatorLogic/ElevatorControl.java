package elevatorLogic;

import java.util.ArrayList;
import java.util.Random;

public class ElevatorControl {
	
	int floor;
	int velocity;
	int passengerCount;
	int maximumPassengers;
	int position;
	ArrayList<Integer> nextPassengerLocation = new ArrayList<Integer>();
	ArrayList<Integer> dropPassengerLocation = new ArrayList<Integer>();
	
	public void addPassenger(){
		if(dropPassengerLocation.size()<maximumPassengers)
			for(int z=0; z<dropPassengerLocation.size(); z++){
				dropPassengerLocation.add(randInt(0,5));
			}
		else
			System.out.println("Someone is trying to get on when the maximum capacity has already been reached. How should this be handled?");
	}
	
	public void removePassenger(){
		if(dropPassengerLocation.size()>0)
			for(int z=0; z<dropPassengerLocation.size(); z++){
				if(dropPassengerLocation.get(z)==floor)
					dropPassengerLocation.remove(z);
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
	
	public int getNextFloor(){
		if(nextPassengerLocation.size()>0)
			return nextPassengerLocation.get(0);
		return -1;
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}