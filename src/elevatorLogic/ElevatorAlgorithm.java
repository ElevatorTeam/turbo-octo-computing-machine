package elevatorLogic;

import java.util.ArrayList;

public class ElevatorAlgorithm extends ElevatorControl {

	boolean thisFloorChecked;
	
	public void runAlgorithm(){
		if(lastButtonPress<floor)
			setVelocity(-1);
		if(lastButtonPress>floor)
			setVelocity(1);
		if(lastButtonPress==floor)
			setVelocity(0);
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
}
