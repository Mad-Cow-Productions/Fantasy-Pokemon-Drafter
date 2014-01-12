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
		FileOutputStream fop = new FileOutputStream(draftList, true);
		try{
		fop = new FileOutputStream(draftList);
		draftList.createNewFile();
		byte[] draftPickInBytes = draftPick.getBytes();
		fop.write('\n');
		fop.write(draftPickInBytes);
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
	public Methods(){
		
	}
	//
}
