import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

class FileUtil {
    public static void writeToFile(String path, String data) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(data);

        writer.close();
    }

    public static String readFromFile(String path) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(path);

        if (file.exists()) {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                stringBuilder.append(reader.nextLine() + "\n");
            }

            reader.close();
        } else {
            throw new FileNotFoundException();
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}