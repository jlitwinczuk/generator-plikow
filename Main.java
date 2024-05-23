import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int fileSize = 10000000;
        int lineLength = 200;
        int numberOfFiles = 50;

        for (int fileNumber = 1; fileNumber <= numberOfFiles; fileNumber++) {
            String fileName = fileNumber + ".txt";
            generateTxtFile(fileName, fileSize, lineLength);
        }
    }

    private static void generateTxtFile(String fileName, int fileSize, int lineLength) {
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            for (int i = 0; i < fileSize; i++) {
                if (i > 0 && i % lineLength == 0) {
                    writer.write('\n');
                }
                char randomChar = (char) (' ' + random.nextInt(95));
                writer.write(randomChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
