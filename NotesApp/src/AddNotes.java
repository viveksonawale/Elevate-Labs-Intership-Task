import org.w3c.dom.ls.LSOutput;

import java.io.FileWriter;
import java.io.IOException;

public class AddNotes {
    public void writeFile(String file, String newFileData) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(newFileData);
        fileWriter.close();
    }
}
