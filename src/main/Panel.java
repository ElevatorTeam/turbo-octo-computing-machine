package main;

//This is the Panel Class for Elevators.
//
//This is the Panel Class for Elevators.
//

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
//import java.io.*;
import javax.swing.*;

public class Panel extends JFrame {

	private static final long serialVersionUID = 1L;
	ImageIcon image = new ImageIcon("background.jpg");
	JLabel imageLabel = new JLabel(image);
	//private JLabel text1;
	private JTextField item1;
	
	//Arrays that create list of items
	ArrayList<JLabel> FloorList = new ArrayList<JLabel>();
	ArrayList<JLabel> DirectionList = new ArrayList<JLabel>();
	ArrayList<JLabel> ElevatorStatus = new ArrayList<JLabel>();
	
	//Second idea for arrays
	ArrayList<JComponent> ElevatorInfo1= new ArrayList<JComponent>();
	
	public Panel(){
		super("Elevator Project");
		setLayout(null);
		
		//adding in objects
		AddComponent();
		PlaceComponent();
		
		//Handler setup
		Handler Handle = new Handler();
		item1.addActionListener(Handle);
	}
	
	public void AddComponent(){
		add(imageLabel);
		item1 = new JTextField("", 25);
		add(item1);
	}
	
	public void PlaceComponent(){
		Dimension size;
		size = item1.getPreferredSize();
		item1.setBounds(25, 20, size.width, size.height);
		size = imageLabel.getPreferredSize();
		imageLabel.setBounds(0, 0,
	             size.width, size.height);
	}
	
	public void updateHandler(){
		item1.repaint();
		item1.revalidate();
	}
	
	private class Handler implements ActionListener{
 		
		public void actionPerformed(ActionEvent event){
		String string = "";
		
		//THIS IS A JOKE THING. JUST TYPE "Doge" WHILE THE WINDOW IS OPEN AND PRESS ENTER.
			if(event.getSource()==item1){
				string=String.format("string: %s", event.getActionCommand());
				if(string.equals("string: Doge")){
					JOptionPane.showMessageDialog(null, "Wow. Very String. Such Java.");
				}
				else{
					JOptionPane.showMessageDialog(null, "Wow. Not Doge.");
				}
			}
		}
	}
}