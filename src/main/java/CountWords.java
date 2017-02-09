import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountWords {
   
    public static void main(String[] args) {
    	 CountWords app = new CountWords();
         System.out.println("Counting words in selected file");
         final String pathGivenByUser = app.askUserForAFilePath();
         checkIfFileExists(pathGivenByUser);
      }
    
    public static int CountWords(String pathGivenByUser) {
    	File file = new File(pathGivenByUser);
    	int count=0;
    	try(Scanner sc = new Scanner(new FileInputStream(file))){
    		while(sc.hasNext()){
		        sc.next();
		        count++;
		    }
		    sc.close();
    	} catch (FileNotFoundException e) {
			e.printStackTrace();;
		}
    	return count;
	}

	public static boolean checkIfFileExists(String path) {		
		if(Files.exists(Paths.get(path)))
		{
			System.out.println("In the file " + CountWords(path) + " words");  
			return true;
		}
    	else 
    	{
    		System.out.println("The file doesn't exist");
    		return false;
    	}			
	}
    
    String askUserForAFilePath() {
		System.out.println("Give me a path");
		Scanner in=new Scanner(System.in);
		return in.nextLine();
	}
}
