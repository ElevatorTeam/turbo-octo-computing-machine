package elevatorProject;

//In case you didn't know, you have to import the packages you create into other packages if you want to use them inside of each other!
//import elevatorLogic.*;
//When we end up using that, we have to uncomment it.

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.util.ResourceLoader;

import elevatorLogic.*;

/*//init is actual called when this class is created inside of ElevatorProject, our main class.
// The reason why, is because each "state" of the game, like the main menu, and the elevator section itself only exists once.
//Therefore, to have the main menu edit in-game things, you must use static methods inside of here, because the class itself is a static instance.
//For example, if we want to have the main menu control whether the game produces a new person every 5 seconds or every 20 seconds, you must make
//a static method, for example "public static void setPassengerCreationRate(double rate){PassengerCreationRate=rate;} or something like that.

//To enter a new state (menus, gameModes, etc), type in sbg.enterState(ElevatorProject.elevatoProgram); inside of the update functon 
//ElevatorProject being the name of our mainclass, and elevatorProgram being the name of that state. 
//"startMenu" would be the start menu state.

//Therefore to make a button in the main menu send you to a difficulty mode where the initial passengerRate is once every 10 seconds,
// you would make it so inside the menu, after clicking on the menu item, you do:
//ElevatorGame.setPassengerCreationRate(10.0);
//sbg.enterState(ElevatorProject.elevatoProgram);Za

//render is called 60 times a second, and update is called inbetween each of those. To keep things clean, it is a REALLY good idea to just have
//render and update call a different class that controls both. In fact, for the menu, the render and update section has 4 different classes, to control
//the init, the render, the update, and also the mouse click. in MouseClicked, button 0 is left click.

//There is a lot of other things about slick2d to learn, so I hope it isn't too much of a hinderance for you, and that these comments helped. 
//Have fun!
*/

public class ElevatorGame extends BasicGameState{
	
	private int state;
    int width;
    int height;
    boolean setWidth= true;
    TrueTypeFont font;
    
    //Everything below this is related to Elevators
    ArrayList<Elevator> ElevatorList = new ArrayList<Elevator>();
    static int renderLocX;
    static Image elevatorImg;
	
	public ElevatorGame(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		elevatorImg= new Image("resources/images/Elevator.png");
		renderLocX = 0;
		ElevatorList.add(new Elevator());
		ElevatorList.add(new Elevator());
		ElevatorList.add(new Elevator());
		ElevatorList.add(new Elevator());
		System.out.println("elevator list size: " + ElevatorList.size());
		Font awtFont;
		try {
			awtFont = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream("game_over.ttf"));
			awtFont = awtFont.deriveFont(84f); // set font size
			font = new TrueTypeFont(awtFont, false);
		} catch (FontFormatException | IOException e) {e.printStackTrace();}
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException{
		if(setWidth){
			width=gc.getWidth();
			height=gc.getHeight();
			setWidth=false;
			g.setFont(font);
			g.setColor(Color.red);
		}
		
		g.drawString("You have " + ElevatorList.size() + " Elevators. Would you like to buy a new one?   BUY", 50, 30);
		
		for(int k=0;k<ElevatorList.size();k++){
			elevatorImg.draw((k*300)+100-renderLocX,height/6,width/8,height/9*4);
			g.drawString("floor " + ElevatorList.get(k).getFloor(),(k*300)+135-renderLocX,height/6+35);
			g.drawString("passengers: " + ElevatorList.get(k).getPassengerCount(),(k*300)+100-renderLocX,height/3*2);
			g.drawString("next Floor: " + ElevatorList.get(k).getFloor(),(k*300)+100-renderLocX,height/3*2+35);
			g.drawString("Velocity:  " + ElevatorList.get(k).getVelocity(),(k*300)+100-renderLocX,height/3*2+70);
		}
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			if(renderLocX<(ElevatorList.size()-3)*300)
				renderLocX+=2;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			if(renderLocX>0)
				renderLocX-=2;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			sbg.enterState(ElevatorProject.startMenu);
		}
	}
	
	public void mouseClicked(int button, int x, int y, int clickCount){
	}
	
	@Override
	public int getID(){
		return this.state;
	}
}