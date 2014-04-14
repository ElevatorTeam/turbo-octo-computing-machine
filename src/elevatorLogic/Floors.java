package elevatorLogic;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Floors {
	static Image Aliens;
	static Image Cardboard;
	static Image Dragons;
	static Image Dungeon;
	static Image Egypt;
	static Image Heaven;
	static Image Hell;
	static Image Underwater;
	public static ArrayList<Image> floorList = new ArrayList<Image>();
	
	public static void initImages() throws SlickException{
		Aliens  = new Image("resources/backgrounds/Aliens.png");
		Cardboard  = new Image("resources/backgrounds/Cardboard.png");
	    Dragons  = new Image("resources/backgrounds/Dragons.png");
		Dungeon = new Image("resources/backgrounds/Dungeon.png");		
		Egypt = new Image("resources/backgrounds/Egypt.png");
		Heaven = new Image("resources/backgrounds/Heaven.png");
		Hell  = new Image("resources/backgrounds/Hell.png");
		Underwater  = new Image("resources/backgrounds/Underwater.png");
		floorList.add(Hell);
		floorList.add(Dungeon);
		floorList.add(Underwater);
		floorList.add(Cardboard);
		floorList.add(Dragons);
		floorList.add(Heaven);
	}
	
	public static void addFloor(){
		floorList.add(floorList.size()-2, floorGet());
	}

	public static Image floorGet(){
		int makeFloor = Elevator.randInt(0,4);
		if(makeFloor==0)
			return Aliens;
		if(makeFloor==1)
			return Cardboard;
		if(makeFloor==2)
			return Dragons;
		if(makeFloor==3)
			return Egypt;
		return Underwater;
	}
	
	public static Image firstFloorGet(){
		return Hell;
	}
	
	public static Image lastFloorGet(){
		return Heaven;
	}
}