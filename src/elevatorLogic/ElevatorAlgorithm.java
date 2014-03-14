package elevatorLogic;

public class ElevatorAlgorithm extends ElevatorControl {
	
	public void getNextPassenger(){
		
		if(nextPassengerLocation.size()>0){
			for(int a=0;a<nextPassengerLocation.size();a++){
				if(nextPassengerLocation.get(a)==floor){
					if(!ElevatorIsFull()){
						addPassenger();
						nextPassengerLocation.remove(a);
					}
				}
			}
			setVelocity(0);
		}
		if(nextPassengerLocation.size()>0){
			if(nextPassengerLocation.get(0)>floor)
				setVelocity(1);
			else if(nextPassengerLocation.get(0)<floor)
				setVelocity(-1);
		}
		else setVelocity(0);
	}
	
	public void doubleCheckDirection(){

		if(nextPassengerLocation.size()>0){
			if(nextPassengerLocation.get(0)<floor && position>0)
				setVelocity(-1);
			if(nextPassengerLocation.get(0)>floor && position<600)
				setVelocity(1);
		}
		else setVelocity(0);
	}

}
