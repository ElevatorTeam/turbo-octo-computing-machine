package elevatorLogic;

import java.util.ArrayList;
import java.util.Random;

public class ElevatorControl {
	
	//This class really doesn't DO anything. It is the same as the MenuCommands class, it is here to create stuff.
	//Most of the functions revolve around getting or setting a variable.
	int floor;
	int velocity;
	int passengerCount;
	int maximumPassengers;
	int position;
	int destination = 0;
	int chosenFloor;
	
	//These 2 ArrayLists are the most important objects in all of the elevator classes.
	//The "nextPassengerLocation" is the amount of people standing outside of the elevators on each floor.
	//for example, if nextPassengerLocation.get(0) is 3, then there are 3 people standing outside of the elevator on floor 0.
	//On the other hand, dropPassengerLocation is the floor people inside the elevator want to be dropped off at.
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

	public void setPosition(){
		position+=velocity;
		if(position>(dropPassengerLocation.size()-1)*120)
			position=(dropPassengerLocation.size()-1)*120;
	}

	public int getPosition(){
		return position;
	}
	
	public int getNextFloor(){
		return destination;
	}
	
	public boolean atTopOrButtom(){
		if(floor<=0 || floor>=(nextPassengerLocation.size()-1))
			return true;
		return false;
	}
	
	public void increaseFloorCount(){
		if(dropPassengerLocation.size()<20){
			nextPassengerLocation.add(0);
			dropPassengerLocation.add(0);
		}
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}