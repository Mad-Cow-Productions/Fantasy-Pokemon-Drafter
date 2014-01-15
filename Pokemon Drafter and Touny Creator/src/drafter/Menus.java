package drafter;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.*;


 


public class Menus {

	private static JFrame enterNames;
	private static JTextField textFieldNames;
	private static JButton confirmNumber;
	public  static String[][] contestantsNames;
	public static int numberOfContestants;
	private static JButton moveOn;
	private static int count = 0;
	private String draftPick;
	Methods method = new Methods();
	
	
	
	
	private static JFrame draft;
	
	public Menus(){
		
	}
	public static void Initiate(){
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
			contestantsNames = new String[numberOfContestants][1];
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
			
			contestantsNames[count][0] = text;
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
			
			JLabel helloLabel = new JLabel();
			
			
			
			
		}
		
	}
	
	
	public int getNumberOfContestants(){
		
		return numberOfContestants;
		
	}
	
	public String[][] getContestantsNames(){
		return contestantsNames;
	}
		
	
	public static void main(String[] args) {
		Initiate();
		
	
	}

}
