/*
Руками создаете файл lektorium1.txt.
В него сами руками запишите число от 0 до 10.
Задача по джаве - считать это число с файла,
возвести его в квадрат и записать в фйал с названием lektorium2.txt.
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWrite {

    static int square(int a) {
        return a * a;
    }

    public static void main(String[] args) throws Exception {

        String inputFilePath = System.getProperty("user.dir") + "/src/main/resources/lektorium1.txt";
        String outputFilePath = System.getProperty("user.dir") + "/src/main/resources/lektorium2.txt";
        Integer number = 0;

        // read number from input file
        try {
            FileReader reader = new FileReader(inputFilePath);
            Scanner scan = new Scanner(reader);
            number = Integer.parseInt(scan.nextLine());
            reader.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        // if output file not exists then create it
        File file = new File(outputFilePath);
        if (!file.exists())
            try {
                boolean created = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        // write square of number to the output file
        FileWriter writer = new FileWriter(outputFilePath);
        try {
            writer.write(Integer.toString(square(number)));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
