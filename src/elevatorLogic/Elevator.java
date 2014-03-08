package elevatorLogic;

import java.util.ArrayList;

public class Elevator {


	
	//This package will be for creating and controlling what the elevators are doing, and NOTHING ELSE.
	//please don't put anything but the elevator object, and the code that controls it, in this project.
	
	int floor;
	int velocity;
	int passengerCount;
	int maximumPassengers;
	ArrayList<Integer> NextPassengerLocation = new ArrayList<Integer>();
	
	public Elevator(){
		floor = 0;
		velocity = 0;
		passengerCount=0;
		maximumPassengers=10;
	}
	
	public Elevator(int floor, int passengerCount){
		this.floor = floor;
		velocity = 0;
		this.passengerCount=passengerCount;
		maximumPassengers=10;
	}
	
	public void setFloor(int newFloor){
		floor=newFloor;
	}
	
	public void setVelocity(int newVel){
		velocity=newVel;
	}
	
	
	//Controls whether a passenger gets on or off
	public void addPassenger(){
		if(passengerCount<maximumPassengers)
			passengerCount++;
		else
			System.out.println("Someone is trying to get on when the maximum capacity has already been reached. How should this be handled?");
	}
	
	public void removePassenger(){
		if(passengerCount>0)
			passengerCount--;
		else
			 System.out.println("Hey, your elevator tried to remove someone that WASNT EVEN THERE. You should probably look in to that.");		
	}
	//
	
	public int getFloor(){
		return floor;
	}
	
	public int getVelocity(){
		return velocity;
	}
	
	public int getPassengerCount(){
		return passengerCount;
	}
}
