package elevatorLogic;

public class ElevatorAlgorithm extends ElevatorControl {
	
	public void getNextPassenger(){
		
		if(nextPassengerLocation.size()>0){
			if(nextPassengerLocation.get(0)==floor)
			//grabs all passengers on this floor
				while(nextPassengerLocation.size()>0){
					if(nextPassengerLocation.get(0)==floor){
					if(!ElevatorIsFull()){
							addPassenger();
							nextPassengerLocation.remove(0);
						}
					}
				setVelocity(0);
			}
			//end grab of passengers
		
			//change direction if next passenger is not on this floor
			else if(nextPassengerLocation.get(0)>0)
				setVelocity(1);
			else if(nextPassengerLocation.get(0)<0)
				setVelocity(-1);
		}
	}
	
	public void dropOffPassengers(){
		
	}

}
