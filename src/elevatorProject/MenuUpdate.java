package elevatorProject;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MenuUpdate extends MenuClick {
	
	//Just don't touch, this has nothing to do with the elevators.

	public void menuUpdate(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		//If the Mouse is grabbed, you can't see it. Useful when outside of menus, but since this IS a menu...
		if(playTheme ==true){
			theme.playAsSoundEffect(1.0f, 1.0f, false);
			playTheme=false;
			Mouse.setGrabbed(false);
			}
	}
}