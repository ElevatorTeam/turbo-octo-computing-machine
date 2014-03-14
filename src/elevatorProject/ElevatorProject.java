package elevatorProject;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ElevatorProject extends StateBasedGame{
	public static final String gamename = "Elevator Simulator 2014";
	public static final int startMenu = 0;
	public static final int elevatorProgram = 1;

	static AppGameContainer appgc;
	
	public ElevatorProject(String gamename)
	{
		super(gamename);
		this.addState(new StartMenu(startMenu));
		this.addState(new ElevatorGame(elevatorProgram));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
	      this.getState(startMenu).init(gc, this);
	      this.getState(elevatorProgram).init(gc, this);
	      this.enterState(startMenu);
	   }
	
	public static void main(String[] args){
		try{
			appgc = new AppGameContainer(new ElevatorProject(gamename));
			appgc.setDisplayMode(appgc.getScreenWidth()/3*2, appgc.getScreenHeight()/3*2, false);
			appgc.setShowFPS(false);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}catch (SlickException ex){
			ex.printStackTrace();
		}
	}
}
