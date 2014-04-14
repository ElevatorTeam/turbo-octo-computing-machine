package elevatorProject;
//You can't change states if you don't have this exception!
import org.lwjgl.openal.AL;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MenuClick extends MenuCommands {
	
	//don't touch
	
	int width;
	int height;
	StateBasedGame sbg;
	
	public void MainClick(int button, int x, int y) throws SlickException{
		if(x>(width/8) && y>(height/3*2) && x<(width/3) && y<(height/5*4))
	     {
	         if(button==0){
	        	 sbg.enterState(ElevatorProject.elevatorProgram);
	         }
	     }
		
		if(x>(width/3*2) && y>(height/3*2) && x<(width/7*6) && y<(height/5*4) )
	     {
	         if(button==0){
	        	 AL.destroy();
	        	 System.exit(0);
	         }
	     }
	}
}