package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileUtil {

    public void createFile(String json,String fileName) {
        try {
            File file = new File(fileName);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(json.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFile(String fileName){
        String output = "";
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                output = reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }
}
