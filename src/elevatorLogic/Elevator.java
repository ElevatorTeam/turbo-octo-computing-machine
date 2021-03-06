package elevatorLogic;

import java.util.ArrayList;
import java.util.Random;

public class Elevator extends ElevatorAlgorithm{

	// This package will be for creating and controlling what the elevators are
	// doing, and NOTHING ELSE.
	// please don't put anything but the elevator object, and the code that
	// controls it, in this project.

	public Elevator(){
		floor = 0;
		velocity = 0;
		prevdirection = 1;
		passengerCount = 0;
		maximumPassengers = 10;
		position = 0;
		for (int k = 0; k < Floors.floorList.size(); k++){
			nextPassengerLocation.add(0);
			dropPassengerLocation.add(0);
			panelList.add(false);
			waitList.add(new WaitTime());
		}
		panelList.set(0, false);
	}

	public boolean ifOnFloor(){
		if (position % 120 == 0)
			return true;
		return false;
	}

	public void setNewFloor(){
		floor = position / 120;
	}

	public void chooseNextFloor(){
		getNextFloor();
	}

	public boolean reachedDestination(){
		if (floor == destination)
			return true;
		return false;
	}

	// Adds one person to a random floor 25% of the time. Curently set to be
	// called once a second insinde the ElevatorGame class.
	public void addRandom(){
		int chances=14;
		if(passengerCount>2)
			chances=16;
		if(passengerCount>4)
			chances=18;
		if(passengerCount>6)
			chances=20;
			if (randInt(0, 20) > chances){
				chosenFloor = randInt(0, nextPassengerLocation.size() - 1);
				if(nextPassengerLocation.get(chosenFloor)==0)
					waitList.get(chosenFloor).startTime();
				nextPassengerLocation.set(chosenFloor, nextPassengerLocation.get(chosenFloor) + randInt(1, 3));
				setDestination();
			}
	}
}
