package elevatorProject;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MenuUpdate extends MenuClick {

	public void menuUpdate(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Mouse.setGrabbed(false);
	        
	        //This is how keyboard Input is done
			if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			}
	}
}