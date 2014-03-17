package elevatorLogic;

import java.util.ArrayList;

public class ElevatorAlgorithm extends ElevatorControl {
	
	public void runAlgorithm(){
		if(lastButtonPress>floor)
			setVelocity(1);
		if(lastButtonPress<floor)
			setVelocity(-1);
	}
	
	public void pickUpPassengers(){
		if(nextPassengerLocation.get(floor)>0)
			for(int z=0;z<nextPassengerLocation.get(floor);z++){
				if(!ElevatorIsFull()){
					addPassenger();
					nextPassengerLocation.set(floor, nextPassengerLocation.get(floor)-1);
				}
			}
	}
	
	public void addPassenger(){
		for(int z=0; z<nextPassengerLocation.get(floor); z++){
			if(passengerCount<maximumPassengers){
				nextPassengerLocation.set(floor, nextPassengerLocation.get(floor)-1);
				dropPassengerLocation.set(randInt(0,5), dropPassengerLocation.get(floor)+1);
				passengerCount++;
			}
		}
	}
	
	public void removePassengers(){
		if(dropPassengerLocation.get(floor)>0){
			for(int z=0; z<dropPassengerLocation.get(floor); z++){
				dropPassengerLocation.set(floor, dropPassengerLocation.get(floor)-1);
				passengerCount--;
			}
		}
	}
}