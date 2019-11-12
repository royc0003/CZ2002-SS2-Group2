import java.io.*;
public class FileIOHelper {

    private static File init(){
        File folder = new File("./data"); // creates a new file
        if(!folder.exists())
            folder.mkdir(); // creates a new directory if not present
        return folder;
    }

    public static File getFile(String name) { // mainly to retrieve file
        File folder = init();
        File n = new File(folder.getAbsolutePath() + File.separator + name);
        return n;
    }
    public static boolean exists(String name){
        File folder = init();
        File f = new File(folder.getAbsolutePath() + File.separator + name);
        return f.exists();
    }

    public static BufferedReader getBufferedReader(String name) throws FileNotFoundException {
        return new BufferedReader(new FileReader(getFile(name)));
    }

    public static BufferedWriter getBufferedWriter(String name) throws IOException {
        return new BufferedWriter(new FileWriter(getFile(name)));
    }

}
