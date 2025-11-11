import java.io.*;
import java.util.*;
public class fileOperator {
    private File myFile;
    private Scanner fileReader;
    public fileOperator (String fileName) throws IOException{
        setFile(fileName);
    }
    public void setFile(String fileName) throws IOException {
        myFile = new File(fileName);
        fileReader = new Scanner(myFile);
    }
    public String readLine() {
        if (fileReader.hasNextLine()) {
            return fileReader.nextLine();
        } else {
            return null;
        }
    }
    public void close() {
        fileReader.close();
    }
}
