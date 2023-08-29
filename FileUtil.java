import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

class FileUtil {
    public static void writeToFile(String path, String data) throws Exception {
        // Creating a file writer
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        // Writing to the file
        writer.write(data);

        // Closing the writer
        writer.close();
    }

    public static int characterCount(String filename) throws Exception {
        // Initializing character count
        int characterCount = 0;

        // Creating a File object
        File file = new File(filename);

        // Making sure the file exists
        if (file.exists()) {
            // Creating a scanner to read the file
            Scanner reader = new Scanner(file);

            // Looping through the file's characters and counting them
            while (reader.hasNext()) {
                String line = reader.nextLine();
                characterCount += line.length();
            }

            // Closing the reader
            reader.close();
        } else {
            // Throwing an exception if the file doesn't exist
            throw new FileNotFoundException();
        }

        // Returning the total character count
        return characterCount;
    }

    public static String readFromFile(String path) throws Exception {

        // Creating a StringBuilder to store file data
        StringBuilder stringBuilder = new StringBuilder();

        // Declaring the File object
        File file = new File(path);

        // Making sure the file exists
        if (file.exists()) {
            // Creating a scanner to read the file
            Scanner reader = new Scanner(file);

            // Looping through the file's lines and adding them to the StringBuilder with
            // newlines
            while (reader.hasNextLine()) {
                stringBuilder.append(reader.nextLine() + "\n");
            }

            // Closing the reader
            reader.close();
        } else {
            // Throwing an exception if the file doesn't exist
            throw new FileNotFoundException();
        }

        // Deleting the extra newline at the end
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        // Returning our finished string
        return stringBuilder.toString();
    }
}