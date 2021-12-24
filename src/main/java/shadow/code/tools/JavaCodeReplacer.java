package shadow.code.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaCodeReplacer {

    public static void replace(File file, String regex, String replacement) throws IOException {
        List<String> lines = FileReader.readAllLines(file);
        List<String> replacedLines = new ArrayList<>();

        for (String line : lines) {
            replacedLines.add(line.replaceAll(regex, replacement));
        }

        FileOutputStream outputStream = new FileOutputStream(file);
        for (String line : replacedLines) {
            byte[] strToBytes = (line + "\n").getBytes();
            outputStream.write(strToBytes);

        }
        outputStream.close();
    }
}
