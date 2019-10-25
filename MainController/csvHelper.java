import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
/**
* @author Royce Ang;
**/

public class csvHelper {
    private static final String PIPE_DELIMITER = "\\|\\|\\|";

    protected List<String[]> readAll(BufferedReader reader) throws IOException {
        List<String[]> results = new ArrayList<>();
        String line = "";
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            results.add(line.split(PIPE_DELIMITER));
        }
        return results;
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

