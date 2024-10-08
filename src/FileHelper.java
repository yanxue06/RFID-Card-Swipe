import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

   public static ArrayList<String> readFile(String filePath, boolean printOut)  {
          
        //a list to remember what we read from the file
        ArrayList<String> lines = new ArrayList();
        
        try {
            //set up buffered reader
            java.io.FileReader fr = new java.io.FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            //do the reading (print out and save into list)
            String line="";
            int count=0;
            while( (line = br.readLine()) != null) {
                lines.add(line);
                if (printOut)
                    System.out.println("File read line " + count + " : " + line);
                count++;
            }

            br.close();
        }
        catch(Exception e) {
            System.out.println("Error file reading!");
            System.exit(0);
        }
  
        return(lines);
    }
   
   public static void listToFile(String fn, List<String> list) {
        try {
            FileWriter fw = new FileWriter(fn);
            BufferedWriter br = new BufferedWriter(fw);
           
            for( int k=0 ; k<list.size(); k++) {
                String temp = list.get(k);
                br.write(temp + "\n");
            }
            br.close();
        }
        catch(Exception e) {
            System.out.println("Error writing to file");
        }
   }
    
    
}
