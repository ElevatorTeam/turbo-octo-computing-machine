package elevatorLogic;

public class ElevatorPassengers extends ElevatorControl {
	
	//Everything below here controls the passengers
		public void pickUpPassengers(){
			if(floor>0){
				if(nextPassengerLocation.get(floor)>0)
					if(!ElevatorIsFull()){
						addPassengers();
					}
			}
			else System.out.println("floor is greater than zero!");
		}
		
		public void addPassengers(){
			for(int z=0; z<nextPassengerLocation.get(floor); z++){
				if(!ElevatorIsFull()){
					nextPassengerLocation.set(floor, nextPassengerLocation.get(floor)-1);
					dropPassengerLocation.set(randInt(0,5), dropPassengerLocation.get(floor)+1);
					passengerCount++;
				}
			}
		}
		
		public void removePassengers(){
			if(floor>0){
				if(dropPassengerLocation.get(floor)>0)
					for(int z=0; z<dropPassengerLocation.get(floor); z++){
						dropPassengerLocation.set(floor, dropPassengerLocation.get(floor)-1);
						passengerCount--;
					}
			}
			else System.out.println("floor is greater than zero!");
		}
}
