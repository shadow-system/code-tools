package shadow.code.tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileSearcher {

    public static List<File> getAllRecursively(String absolutePath, Predicate<File> predicate) throws IOException {
        File file = new File(absolutePath);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("No directory at " + absolutePath);
        }
        return Files.walk(Paths.get(absolutePath))
            .filter(Files::isRegularFile)
            .map(Path::toFile)
            .filter(predicate)
            .collect(Collectors.toList());
    }
}
