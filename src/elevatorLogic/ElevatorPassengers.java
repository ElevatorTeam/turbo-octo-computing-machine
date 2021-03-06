package elevatorLogic;

public class ElevatorPassengers extends ElevatorControl {
	
	int passengerCount;
	int maximumPassengers;
	
		//Everything below here controls the passengers
		public void pickUpPassengers(){
			if(floor>=0){
				if(nextPassengerLocation.get(floor)>0){
					if(!ElevatorIsFull()){
						addPassengers();
						totalTime+=waitList.get(floor).endTime();
						amountOfWaits++;
						averagedTime=totalTime/amountOfWaits;
					}
				}
			}
		}

		public void addPassengers(){
			for(int z=0; z<nextPassengerLocation.get(floor); z++){
				if(!ElevatorIsFull()){
					nextPassengerLocation.set(floor, nextPassengerLocation.get(floor)-1);
					int randFloor = floor;
					wait=150;
					while(floor == randFloor)
						randFloor = randInt(0,dropPassengerLocation.size()-1);
					dropPassengerLocation.set(randFloor, dropPassengerLocation.get(floor)+1);
				}
			}
		}
		
		public void removePassengers(){
			if(floor>=0){
				if(dropPassengerLocation.get(floor)>0)
					for(int z=0; z<dropPassengerLocation.get(floor); z++){
						dropPassengerLocation.set(floor, dropPassengerLocation.get(floor)-1);
						wait=150;
					}
			}
		}
		
		public void setPassengerCount(){
			passengerCount=0;
			for(int k = 0;k<dropPassengerLocation.size();k++)
				if(dropPassengerLocation.get(k)>0)
					passengerCount+=dropPassengerLocation.get(k);
		}

		public int getPassengerCount(){
			return passengerCount;
		}

		public boolean ElevatorIsFull(){
			return(maximumPassengers==passengerCount);
		}
}