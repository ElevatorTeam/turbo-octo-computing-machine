package elevatorProject;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class StartMenu extends BasicGameState{
	
	private int state;
    int width;
    int height;
    boolean setWidth= true;
    MenuRender MenuManager;
	
	public StartMenu(int state) {
		 this.state = state;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		MenuManager = new MenuRender();
		MenuManager.initMain();
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		if(setWidth){
			width=gc.getWidth();
			height=gc.getHeight();
			MenuManager.initClick(sbg, width, height);
			setWidth=false;
			}
		MenuManager.menuSelect(gc,sbg,g);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException{
		MenuManager.menuUpdate(gc, sbg, delta);
	}
	
	public void mouseClicked(int button, int x, int y, int clickCount){
		try {
			MenuManager.MainClick(button, x, y);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getID(){
		return this.state;
	}
}