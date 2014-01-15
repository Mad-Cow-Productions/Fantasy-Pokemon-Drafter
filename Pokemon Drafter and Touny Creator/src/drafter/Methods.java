package drafter;
import java.io.*;
import java.util.Random;

public class Methods extends Menus{
	String fileName = "C:" + File.separator + "Pokemon Showdown Drafter" + File.separator + "Draft List.txt";
	File draftList = new File(fileName);
	String mainDirName = "C:" + File.separator + "Pokemon Showdown Drafter";
	File mainDir = new File(mainDirName);
	String configFileName = "C:" + File.separator + "Pokemon Showdown Drafter" + File.separator + "Valid Pokemon Config.txt";
	File configFile = new File(configFileName);
	private String validPokemon;

	public void createDir(){
		mainDir.mkdir();
	}
	public void createFile(){
		try {
			draftList.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeToFile(){
		FileOutputStream fop = new FileOutputStream(draftList, true);
		try{
		fop = new FileOutputStream(draftList);
		byte[] draftPickInBytes = draftPick.getBytes();
		fop.write('\n');
		fop.write(draftPickInBytes);
		fop.close();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (fop != null){
					fop.close();
				}
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public int pickPerson(String[][] drafterList){
	Menus.getNumberOfContestants()
		Random rnd = new Random();
		int rand = rnd.nextInt(numberOfContestants);
		return rand;
	}
	public boolean getNextRoundOrder(int roundNumber){ //this method will choose the order of the next round for each contestant
	Menus.getContestantsNames();
	Menus.getNumberOfContestants()
        if(roundNumber > 10) {
                return false;
        }else{

                for(int i=0; i > numberOfContestants; i++){

                        int newPos = -(contestantsNames[i][1]) +(numberOfContestants - 1);
                        contestantsNames[i][1] = newPos;

                }
                
                return true;
                

        }

	}
	public boolean checkValidChoice(String pokemonChoice){   //this method will check if the pokemonChoice is a valid one

        if(validPokemon.contains(pokemonChoice)){

        return true;
        
        }else{

        return false;   
        
        }
       

}
	public void readConfig() {
        byte[] configByte = new byte[0];
        try {
        FileInputStream configStream = new FileInputStream(configFile);
        int configLength = configStream.available();
        configByte = new byte[configLength];
        configStream.read(configByte);
        configStream.close();
        String validPokemon = new String(configByte);
        } catch (FileNotFoundException fnfe) {
        	
        } catch (IOException ioe){
        	
        }
	}
	
	public Methods(){
		
	}
	//
}
