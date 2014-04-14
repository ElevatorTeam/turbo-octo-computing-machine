package elevatorProject;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MenuRender extends MenuUpdate{
	
	//don't touch.
	
	static int posX = Mouse.getX();
    static int posY = Mouse.getY();

    public void initClick(StateBasedGame statebased, int w, int h) {
		super.width=w;
		super.height=h;
		super.sbg = statebased;
	}
	
	public void menuSelect(GameContainer gc, StateBasedGame sbg, Graphics g){
		MenuBack.draw(0,0,width,height);
		g.setFont(font);
		g.setColor(Color.green);
		Start.draw(width/8, height/3*2);
		Quit.draw(width/4*3, height/3*2);
		//g.drawString("Enter Game", width/8, height/3*2);
		//g.drawString("Quit", width/4*3, height/3*2);
	}
}