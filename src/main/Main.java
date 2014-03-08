package main;
import javax.swing.*;
import java.util.*;
public class Main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	static ArrayList<EleClass> EleList = new ArrayList<EleClass>();
	
	public static void main(String[] args) {
		Creation created= new Creation();
		created.ArrayCreation(EleList);
		created.PanelCreation();
	}
}

//Daleb's Will:
//In the event of a velicoraptor attack against Daleb:
//Daleb's blender will fall to Anna, Elyse, and Corrin.
//Daleb's laptop goes with Daleb to the afterlife.
//Daleb's Oculus Rift goes to Corrin.
//Daleb's wii goes to Kaneen.
//Daleb's wii SD card goes to Bianca.
// Daleb's magical pants go to Corrin.
//Daleb's dogecoins go to Dylan.
//Daleb's piano goes to Elyse.