package utils;

import java.io.File;

public class PathUtils {

    public static String getTestFileAbsolutePath() {
        String projectPath = "src/test/resources/TestDataFiles/testData.xlsx"; // Relative path
        File file = new File(projectPath);
        return file.getAbsolutePath();
    }
}
