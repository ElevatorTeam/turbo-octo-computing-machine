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
//sbg.enterState(ElevatorProject.elevatoProgram);

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
    static Image buyElevator;
    static Image buyFloor;
    static Image bottomHud;
    static Image topHud;
    static Image door1;
    static Image door2;
    static Image panel;
    
	
	public ElevatorGame(int state) {
		 this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		Floors.initImages();
		elevatorImg= new Image("resources/images/Elevator.png");
		buyElevator= new Image("resources/images/Bewton1.png");
		buyFloor= new    Image("resources/images/Bewton2.png");
		bottomHud= new   Image("resources/images/bottomHud.png");
		topHud= new   Image("resources/images/topHud.png");
		door1= new   Image("resources/images/door1.png");
		door2= new   Image("resources/images/door2.png");
		panel= new Image("resources/images/panel.png");
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
			awtFont = Font.createFont(Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream("Aero.ttf"));
			awtFont = awtFont.deriveFont(120f); // set font size
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
			g.setColor(Color.orange);
		}
		
		for(int k=0;k<ElevatorList.size();k++){
			for(int z=0;z<Floors.floorList.size();z++)
				Floors.floorList.get(z).draw(k*482-renderLocX, (int) (ElevatorList.get(k).getPosition()*4.0166667) - 482*z - 116);
			elevatorImg.draw((k*482)+170-renderLocX,height/6,width/8,height/9*4);
			panel.draw((k*482)+192-renderLocX,height/6+60);
			panelDraw((k*482)+196-renderLocX,height/6+65, g, k, gc);
			door1.draw((k*482)+170-renderLocX-ElevatorList.get(k).getDoors(),height/6+50,width/16,height/9*4-50);
			door2.draw((k*482)+237-renderLocX+ElevatorList.get(k).getDoors(),height/6+50,width/16,height/9*4-50);
			g.drawString("" + (ElevatorList.get(k).getFloor() + 1), (k*480)+200-renderLocX,height/6+18);
			g.drawString("" + (ElevatorList.get(k).getNextFloor() + 1), (k*480)+260-renderLocX,height/6+18);
		}
		
		bottomHud.draw(0,gc.getHeight()/3*2);
		topHud.draw(0,0);
		buyFloor.draw(900,15);
		buyElevator.draw(900,50);
		g.drawString("" + moneyCount, 150, 20);
		g.drawString("" + ElevatorList.size()*4, 245, 55);
		g.drawString("" + ElevatorList.size(), 670, 20);
		g.drawString("" + Floors.floorList.size(), 620, 60);
		for(int k=0;k<ElevatorList.size();k++){
			g.drawString(ElevatorList.get(k).getPassengerList(), (k*480)+100-renderLocX,height/4*3);
			g.drawString(ElevatorList.get(k).getPeopleList(), (k*480)+100-renderLocX,height/4*3+50);
			g.drawString("Passenger Count: " + ElevatorList.get(k).getPassengerCount(), (k*480)+100-renderLocX,height/4*3+100);
		}
	}
	
	public void panelDraw(int X, int Y, Graphics g, int k, GameContainer gc) {
		int number=0;
		g.setColor(Color.gray);
		for(int row=1;row<=5;row++){
			for(int col=1;col<=3;col++){
				if(k<Floors.floorList.size() && (number)<Floors.floorList.size())
					if(ElevatorList.get(k).getPanelNumbers().get(number))
						g.setColor(Color.orange);
					if((number)<Floors.floorList.size())
						g.drawString(""+ (number+1), X+(30*(col-1)), Y+(30*(row-1)));
					g.setColor(Color.gray);
				number++;
			}
		}
		g.setColor(Color.orange);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		//this is called 60 times a second, so everything happens at least once per frame
		
		//sets everything that happens in each elevator
		for(int q=0;q<ElevatorList.size();q++){
			//sets position of each elevator
			ElevatorList.get(q).setPosition();
			
			//once a second, a new person is sometimes added to a random floor per elevator
			if(frameCount%120==0 || frameCount <=3)
				ElevatorList.get(q).addRandom();
			
			//if the elevator is sitting on a floor, so it can open its doors and take passengers.
			if(ElevatorList.get(q).ifOnFloor()){
				//it finds out what floor it is.
				ElevatorList.get(q).setNewFloor();
				//It lets anyone off who is getting off here.
				ElevatorList.get(q).removePassengers();
				//picks up anyone who is on this floor.
				ElevatorList.get(q).pickUpPassengers();
				//sets direction to head.
				ElevatorList.get(q).setDestination();
				//This is the algorithm. This is what tells the elevator where to go.
				ElevatorList.get(q).runAlgorithm();
				//This sets how many passengers are on board the elevator
				ElevatorList.get(q).setPassengerCount();
			}
		}
		
		//End of all the elevator code.
		//
		//
		
		moneyUpdate=ElevatorList.size()/2 + Floors.floorList.size()-6;
		
		if(frameCount%60==0 && moneyCount<1000){
		 moneyCount+=moneyUpdate;
		}
		
		if(moneyCount>999)
			moneyCount=999;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			if(renderLocX>0)
				renderLocX-=10;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			if(renderLocX<(ElevatorList.size()-2)*482-150)
				renderLocX+=10;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			sbg.enterState(ElevatorProject.startMenu);
		}
		
		frameCount+=1;
	}
	
	public void mouseClicked(int button, int x, int y, int clickCount){
		if (button == 0) {
			///This buys a new elevator
			if (x > 900 && x < 1030)
				if (y > 50 && y < 75)
					if (moneyCount >= ElevatorList.size() * 4) {
						moneyCount -= ElevatorList.size() * 4;
						ElevatorList.add(new Elevator());
					}

			//This buys a new floor
			if (x > 900 && x < 1030)
				if (y > 15 && y < 40)
					if (moneyCount >= 50){
						for (int w = 0; w < ElevatorList.size(); w++) {
							ElevatorList.get(w).increaseFloorCount();
						}
						if(Floors.floorList.size()<15)
						{
							Floors.addFloor();
							moneyCount-=50;
						}
					}
		}
	}
	
	@Override
	public int getID(){
		return this.state;
	}
}