package drafter;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.*;


 


public class Menus {
	private static JFrame frame;
	private JLabel label;
	private JButton addText;
	private static JTextField textField;
	private JButton acceptchoices;
	public Array contestantsNames;
	private static JTextField test;
	
	
	private static int Width;
	private static int Height; //Here is where I define the varibles for the pos for the text boxes
	
	public Menus(){
		frame = new JFrame("Pokemon Drafter");
		Toolkit tk = Toolkit.getDefaultToolkit();
		frame.setLocation(0,0);							//this is where the JFrame is created and configured
		frame.setLayout(null);
		frame.setSize(tk.getScreenSize().width, tk.getScreenSize().height); //gets the screen size and sets the JFrame to fit the whole screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Width = frame.getWidth()/3;
		Height = frame.getHeight()/20 + 75;
		

		label = new JLabel("Please Enter Names of Contestants(Seperate Names by a comma)");
		label.setBounds(frame.getWidth()/3, frame.getHeight()/20, 400, 100); //JLabel
		frame.add(label);
		
		
		textField = new JTextField("Enter Names Here");
		textField.setBounds(Width, Height, 200, 25); //JTextField
		frame.add(textField);
		
		acceptchoices = new JButton();
		acceptchoices.setText("Click Here When You Want to Finalize Your Choices");
		acceptchoices.setBounds(frame.getWidth()/3 + 425, frame.getHeight()/20 + 125, 500, 100);
		frame.add(acceptchoices);
		acceptchoices.addActionListener(new Action());
		
		addText = new JButton();
		addText.setText("+");
		addText.setBounds(Width + 225, Height, 50, 25);
		addText.addActionListener(new addTextField());
		frame.add(addText);
		
	}
	
	public void setOpen(boolean torf){
		if(torf == true){
			frame.setVisible(true);
		}else{
			frame.setVisible(false);
		}
	}
	
	static class addTextField implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Height = Height + 50;
			test = new JTextField();
			test.setBounds(Width, Height, 200, 25);
			frame.add(test);
			frame.setVisible(true);
			
			
			
		}
		
		
	}
	
	static class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//whatever goes here will be executed only when the button "acceptchoice' is pressed
			String text = test.getText();
			
			
			JFrame testFrame = new JFrame("Test");
			testFrame.setLocation(0,0);							
			testFrame.setLayout(null);
			testFrame.setSize(500, 500); 
			testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel testLabel = new JLabel();
			testLabel.setText(text);
			testLabel.setBounds(40,40,100,50);
			/*if(text.contains(",")) {
				testLabel.setText("False");
			}else{
				testLabel.setText(text);
			}*/
			testFrame.add(testLabel);
			testFrame.setVisible(true);
		
		}
		
	}
	
	public static void main(String[] args) {
		Menus test = new Menus();
		test.setOpen(true);
	
	}

}
