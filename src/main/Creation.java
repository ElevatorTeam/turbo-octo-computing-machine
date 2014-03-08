package main;
import java.util.ArrayList;

//import java.util.ArrayList;
import javax.swing.JFrame;

public class Creation {
	
	void ArrayCreation(ArrayList<EleClass> EleList){
		for(int ElevatorCount = 0; ElevatorCount <5; ElevatorCount++){
		   EleList.add(new EleClass());
		   EleList.get(ElevatorCount).setFloor(ElevatorCount);
	    }
	}
	
	void PanelCreation(){
		Panel test = new Panel();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setSize(880,300);
		test.setVisible(true);
	}
}