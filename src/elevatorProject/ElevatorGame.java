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

//THIS IS THE ONLY CLASS IN THIS PACKAGE YOU SHOULD REALLY BE TOUCHING AT ALL. This is the render class and update class
//for the game half of this project.
//The elevatorLogic package is the second half, which is what actually touches the elevators.

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
    static int moneyCount;
    static int frameCount;
    static int moneyUpdate;
	
	public ElevatorGame(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		elevatorImg= new Image("resources/images/Elevator.png");
		renderLocX = 0;
		moneyCount = 0;
		frameCount = 0;
		moneyUpdate= 1;
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
		g.drawString("You have " + moneyCount + " dollars.", 50, 55);
		g.drawString("A new elevator will cost you " + ElevatorList.size()*4 + " dollars." + " A new floor costs 50 dollars.", 300, 55);
		g.drawString("Buy floor", 900, 25);
		
		for(int k=0;k<ElevatorList.size();k++){
			elevatorImg.draw((k*300)+100-renderLocX,height/6,width/8,height/9*4);
			g.drawString("floor " + (ElevatorList.get(k).getFloor() + 1), (k*300)+135-renderLocX,height/6+35);
			g.drawString("passengers: " + ElevatorList.get(k).getPassengerCount(),(k*300)+100-renderLocX,height/3*2);
			g.drawString("next floor:  " + (ElevatorList.get(k).getNextFloor() + 1),(k*300)+100-renderLocX,height/3*2+35);
			g.drawString("Velocity:  " + ElevatorList.get(k).getVelocity(),(k*300)+100-renderLocX,height/3*2+70);
			g.drawString("Position:  " + ElevatorList.get(k).getPosition(),(k*300)+100-renderLocX,height/3*2+105);
		}
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		
		
		//
		//
		//this is called 60 times a second, so everything happens at least once per frame
		
		//sets everything that happens in each elevator
		for(int q=0;q<ElevatorList.size();q++){
			//sets position of each elevator
			ElevatorList.get(q).setPosition();
			
			//once a second, a new person is sometimes added to a random floor per elevator
			if(frameCount%60==0)
				ElevatorList.get(q).addRandom();
			
			//if the elevator is sitting on a floor, so it can open its doors and take passengers.
			if(ElevatorList.get(q).ifOnFloor()){
				//it finds out what floor it is.
				ElevatorList.get(q).setNewFloor();
				//It lets anyone off who is getting off here.
				ElevatorList.get(q).removePassengers();
				//picks up anyone who is on this floor.
				ElevatorList.get(q).pickUpPassengers();
				//This is the algorithm. This is what tells the elevator where to go.
				if(ElevatorList.get(q).reachedDestination() || frameCount<2 || ElevatorList.get(q).atTopOrButtom())
					ElevatorList.get(q).runAlgorithm();
			}
		}
		
		//End of all the elevator code.
		//
		//
		
		moneyUpdate=ElevatorList.size()/2;
		
		if(frameCount%60==0){
		 moneyCount+=moneyUpdate;
		}
	
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			if(renderLocX>0)
				renderLocX-=4;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			if(renderLocX<(ElevatorList.size()-3)*300-100)
				renderLocX+=4;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			sbg.enterState(ElevatorProject.startMenu);
		}
		
		frameCount+=1;
	}
	
	public void mouseClicked(int button, int x, int y, int clickCount){
		
		//This is how you buy a new elevator! 
		if (button == 0) {
			// buying new elevator
			if (x > 550 && x < 600)
				if (y > 25 && y < 50)
					if (moneyCount >= ElevatorList.size() * 4) {
						moneyCount -= ElevatorList.size() * 4;
						ElevatorList.add(new Elevator());
					}

			if (x > 900 && x < 1000)
				if (y > 25 && y < 50)
					if (moneyCount >= 50){
						for (int w = 0; w < ElevatorList.size(); w++) {
							// add one floor to all elevators!
							ElevatorList.get(w).increaseFloorCount();
						}
						moneyCount-=50;
					}
		}
	}
	
	@Override
	public int getID(){
		return this.state;
	}
}