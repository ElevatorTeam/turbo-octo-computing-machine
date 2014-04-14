package elevatorProject;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ElevatorProject extends StateBasedGame{
	
	//This is the main class here! Also don't touch, has nothing to do with the elevator project itself.
	
	public static final String gamename = "Elevator Simulator 2014";
	public static final int startMenu = 0;
	public static final int elevatorProgram = 1;

	static AppGameContainer appgc;
	
	public ElevatorProject(String gamename)
	{
		super(gamename);
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		this.addState(new StartMenu(startMenu));
		this.addState(new ElevatorGame(elevatorProgram));
		this.enterState(startMenu);
	   }
	
	public static void main(String[] args){
		try{
			appgc = new AppGameContainer(new ElevatorProject(gamename));
			appgc.setDisplayMode(1600/3*2, 900/3*2, false);
			appgc.setShowFPS(false);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}catch (SlickException ex){
			ex.printStackTrace();
		}
	}
}