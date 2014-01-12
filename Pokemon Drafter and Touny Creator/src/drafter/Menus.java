package drafter;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

 

public class Menus {
	private JFrame frame;
	private JLabel label;
	private static JTextArea textarea;
	private JButton acceptchoices;
	
	public Menus(){
		frame = new JFrame("Pokemon Drafter");
		Toolkit tk = Toolkit.getDefaultToolkit();
		frame.setLocation(0,0);							//this is where the JFrame is created and configured
		frame.setLayout(null);
		frame.setSize(tk.getScreenSize().width, tk.getScreenSize().height); //gets the screen size and sets the JFrame to fit the whole screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel("Please Enter Names of Contestants(Seperate Names by a comma)");
		label.setBounds(frame.getWidth()/3, frame.getHeight()/20, 400, 100); //JLabel
		frame.add(label);
		
		textarea = new JTextArea("Enter Names Here");
		textarea.setBounds(frame.getWidth()/3, frame.getHeight()/20 + 75, 400, 500); //JTextArea
		frame.add(textarea);
		
		acceptchoices = new JButton();
		acceptchoices.setText("Click Here When You Want to Finalize Your Choices");
		acceptchoices.setBounds(frame.getWidth()/3 + 425, frame.getHeight()/20 + 125, 500, 100);
		frame.add(acceptchoices);
		acceptchoices.addActionListener(new Action());
		
	}
	
	public void setOpen(boolean torf){
		if(torf == true){
			frame.setVisible(true);
		}else{
			frame.setVisible(false);
		}
	}
	
	static class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//whatever goes here will be executed only when the button "acceptchoice' is pressed
		}
		
	}
	
	public static void main(String[] args) {
		Menus test = new Menus();
		test.setOpen(true);

	}

}
