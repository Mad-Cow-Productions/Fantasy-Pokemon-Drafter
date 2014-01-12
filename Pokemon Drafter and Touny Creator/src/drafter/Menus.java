package drafter;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.*;


 


public class Menus {
	/*private static JFrame frame;
	private JLabel label;
	private JButton addText;
	private static JTextField textField;
	private JButton acceptchoices;
	public Array contestantsNames;
	private static JTextField test;
	
	
	private static int Width;
	private static int Height; //Here is where I define the varibles for the pos for the text boxes
	*/
	
	private static JFrame enterNames;
	private static JTextField textFieldNames;
	private static JButton confirmNumber;
	public  static String[] contestantsNames;
	private static int numberOfContestants;
	private static JButton moveOn;
	private static int count = 0;
	
	
	
	
	private static JFrame draft;
	
	
	public Menus(){
		Toolkit tk = Toolkit.getDefaultToolkit();
		enterNames = new JFrame();
		enterNames.setLocation(0,0);							//this is where the JFrame is created and configured
		enterNames.setLayout(null);
		enterNames.setSize(tk.getScreenSize().width/2, tk.getScreenSize().height/2); //gets the screen size and sets the JFrame to fit the whole screen
		enterNames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		textFieldNames = new JTextField();
		textFieldNames.setBounds(100,50, 200, 25);
		enterNames.add(textFieldNames);
		
		
		confirmNumber = new JButton();
		confirmNumber.setBounds(325, 50, 50, 25);
		confirmNumber.setText("#");
		confirmNumber.addActionListener(new confirmNumber());
		
		enterNames.add(confirmNumber);
		
		enterNames.setVisible(true);
	}
	
	static class confirmNumber implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			numberOfContestants = Integer.parseInt(textFieldNames.getText());
			contestantsNames = new String[numberOfContestants];
			enterNames.setVisible(false);
			enterNames.remove(confirmNumber);
			textFieldNames.setText(" ");
			moveOn = new JButton();
			moveOn.setBounds(325, 50, 50, 25);
			moveOn.addActionListener(new moveOn());
			enterNames.add(moveOn);
			enterNames.setVisible(true);
			
			
			
			
			
		}
		
	}
	
	static class moveOn implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) { // in this method the names of the contestants are saved to 
			String text = textFieldNames.getText();
			
			contestantsNames[count] = text;
			enterNames.setVisible(false);
			textFieldNames.setText(" ");
			count++;
			if(count >= numberOfContestants){
				enterNames.setVisible(false);
				pickPokemon();
			}else{
			enterNames.setVisible(true);
			}
			
		}

		private void pickPokemon() {
			draft = new JFrame("Drafter");
			draft = new JFrame();
			draft.setLocation(0,0);							//this is where the JFrame is created and configured
			draft.setLayout(null);
			draft.setSize(500, 500); //gets the screen size and sets the JFrame to fit the whole screen
			draft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
	}
		/*frame = new JFrame("Pokemon Drafter");
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
			if(text.contains(",")) {
				testLabel.setText("False");
			}else{
				testLabel.setText(text);
			}
			testFrame.add(testLabel);
			testFrame.setVisible(true);
		
		}
		
	}
	*/
	public static void main(String[] args) {
		Menus test = new Menus();
		
	
	}

}
