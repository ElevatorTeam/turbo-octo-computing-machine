package elevatorProject;
import java.awt.Font;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;


public class MenuCommands {
	
	//don't touch.
	
	int state;
	TrueTypeFont font;
	Image MenuBack;
	Image Start;
	Image Quit;
    Audio soundEffect;
	static Audio theme;
	boolean playTheme = true;
    
    public void initMain() throws SlickException{
			MenuBack = new Image("resources/images/MenuScreen.png");
			Start = new Image("resources/images/Start.png");
			Quit = new Image("resources/images/Quit.png");
		
		//Use the code below for a menu theme!
		try {
	        theme = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("resources/music/menu.ogg"));
	     } catch (IOException e){
	        e.printStackTrace();
	    }	
    }
}