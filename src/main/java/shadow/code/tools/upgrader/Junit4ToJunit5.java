package shadow.code.tools.upgrader;

import shadow.code.tools.FileSearcher;
import shadow.code.tools.JavaCodeReplacer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * This is not full upgrade and can require much more code changes. It has been done only necessary upgrades
 */
public class Junit4ToJunit5 {

    public static void upgrade(String directoryAbsolutePath) throws IOException {
        List<File> files = FileSearcher.getAllRecursively(directoryAbsolutePath, Junit4ToJunit5::hasJavaExtension);
        for (File file : files) {
            JavaCodeReplacer.replace(file, "org.junit.Assert", "org.junit.jupiter.api.Assertions");
            JavaCodeReplacer.replace(file, "org.junit.Test", "org.junit.jupiter.api.Test");
        }
    }

    private static boolean hasJavaExtension(File file) {
        Optional<String> extension = getExtensionByStringHandling(file.getName());
        return extension.isPresent() && extension.get().equals("java");
    }

    private static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
            .filter(f -> f.contains("."))
            .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
}
