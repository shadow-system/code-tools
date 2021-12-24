package shadow.code.tools;

import shadow.code.tools.upgrader.Junit4ToJunit5;

import java.io.IOException;

public class ToolRunner {

    public static void main(String[] args) throws IOException {
        Junit4ToJunit5.upgrade("/home/wraith/dev/project/shadow/code-tools/src/main/resources/junit-test");
    }
}
