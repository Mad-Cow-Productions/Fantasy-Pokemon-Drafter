package drafter;
import java.awt.Color;
import java.awt.Component;
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
	public static String draftPick;
	public static int roundNumber = 0;
	static Methods method = new Methods();
	public static String numberOfPos;
	private static String nextPerson;
	private static JTextField enterPokemon;
	private static String pokemonChoice;
	private static Color red = new Color(250,0,0);
	private static Color black = new Color(0,0,0);
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	
	
	
	
	
	
	private static JFrame draft;
	
	public Menus(){
		
	}
	public static void Initiate(){
		method.createDir();
		method.createFile();
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
		
		enterPokemon = new JTextField();
		enterPokemon.setBounds(250, 250, 200, 50);
	}
	
	static class confirmNumber implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			numberOfContestants = Integer.parseInt(textFieldNames.getText());
			contestantsNames = new String[numberOfContestants][2];
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
	
	static class nextChoiceOfPerson implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			pokemonChoice = enterPokemon.getText();
			draft.setVisible(false);
			
			if(method.checkValidChoice(pokemonChoice)){
				
				enterPokemon.setText(" ");
				enterPokemon.setForeground(black);
				
				
				
				method.writeToFile(nextPerson, pokemonChoice);
				
				numberOfPos = String.valueOf(Integer.parseInt(numberOfPos) + 1);
				
				
				if(Integer.parseInt(numberOfPos) < numberOfContestants - 1){
					
					pickPokemon(numberOfPos);
					
				}else{
					roundNumber = roundNumber + 1;
					
					if(roundNumber > 10){
						
					}else{
						contestantsNames = method.getNextRoundOrder();
						pickPokemon("0");
					}
					
				}
				
			}else{
				
				enterPokemon.setForeground(red);
				enterPokemon.setText("That is not a valid Choice");
				draft.setVisible(true);
				
			}
			
			
			
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
				pickPokemon("0");
			}else{
			enterNames.setVisible(true);
			}
			
		}



		
		
		
	}
	
	public static void pickPokemon(String posNumber) {
		numberOfPos = posNumber;
		
		
		
		draft = new JFrame("Drafter");
		draft = new JFrame();
		draft.setLocation(0,0);							//this is where the JFrame is created and configured
		draft.setLayout(null);
		draft.setSize(tk.getScreenSize().width, tk.getScreenSize().height); //gets the screen size and sets the JFrame to fit the whole screen
		draft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel helloLabel = new JLabel();
		contestantsNames = method.pickPerson();
		
		/*for(int i = 0; i < numberOfContestants; i++){
			
			for(int e = 0; e <= 1; e++){
				
				System.out.println(contestantsNames[i][e]);
				
			}
			
		}*/
		int indexOfPos = getIndexOf(numberOfPos, contestantsNames);
		//System.out.println(indexOfPos);
		nextPerson = contestantsNames[indexOfPos][0];
		helloLabel.setText(nextPerson + " Please Give your Choice in the Box Below");
		helloLabel.setBounds(250, 100, 300, 50);
		draft.add(helloLabel);
		
		
		draft.add(enterPokemon);
		
		JButton nextChoice = new JButton();
		nextChoice.setText("Finalize your Decision");
		nextChoice.setBounds(475, 250, 25,25);
		nextChoice.addActionListener(new nextChoiceOfPerson());
		draft.add(nextChoice);
		
		draft.setVisible(true);
		
		
		
		
	}
	
	
	public static int getIndexOf(String toSearch, String[][] tab ){
		
		
		for(int s = 0; s < numberOfContestants; s++){
			
			if(contestantsNames[s][1].equalsIgnoreCase(toSearch)){
				
				return s;
			}
			
			
		}
		
		return -1;
		
		
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
