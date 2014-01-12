package drafter;
import java.io.*;

public class Methods {
	String fileName = "C:" + File.separator + "Pokemon Showdown Drafter" + File.separator + "Draft List.txt";
	File draftList = new File(fileName);
	String mainDirName = "C:" + File.separator + "Pokemon Showdown Drafter";
	File mainDir = new File(mainDirName);

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
		
	}
	public Methods(){
		
	}
	//
}
