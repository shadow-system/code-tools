package shadow.code.tools;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReader {


    public static List<String> readAllLines(File file) throws IOException {
        List<String> lines = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String currentLine;
        while((currentLine=br.readLine()) != null) {
            lines.add(currentLine);
        }
        return lines;
    }
}
