import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * reads and writes information to and from csv file 
 *
 */
public class csvHelper {
    private static final String PIPE_DELIMITER = "\\|\\|\\|";

   /* protected List<String[]> readAll(BufferedReader reader) throws IOException {
        List<String[]> results = new ArrayList<>();
        String line = "";
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            results.add(line.split("\\|\\|\\|"));
        }
        return results;
    }*/
    
   /**
    *  
    * @param reader
    * @param skip
    * @return
    */
   protected List<String[]> readAll(BufferedReader reader, int skip) {
       List<String> tmp = reader.lines().collect(Collectors.toList());
       if (tmp.size() == 0) return new ArrayList<>(); // Empty CSV file
       IntStream.range(0, skip).forEach((i) -> tmp.remove(0));
       List<String[]> result = new ArrayList<>();
       tmp.forEach((s) -> {
           if (s.trim().isEmpty()) return; // Ignore this line
           result.add(s.split("\\|\\|\\|"));
       });
       return result;
   }


    protected void writeToCSVFile(List<String[]> writeStrings, BufferedWriter writer){
        PrintWriter n = new PrintWriter(writer);
        for(String[] item: writeStrings){
            n.println(String.join("|||", item));
        }
        n.flush();
        n.close();
    }
}