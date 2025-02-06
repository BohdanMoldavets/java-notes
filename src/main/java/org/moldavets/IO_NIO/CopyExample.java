package org.moldavets.IO_NIO;

import java.io.*;

public class CopyExample {

    public static final String PROJECT_PATH =  "C:\\Users\\steam\\IdeaProjects\\java-notes\\src\\main\\resources\\";

    public static void main(String[] args) {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PROJECT_PATH + "file1.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PROJECT_PATH + "file2.txt"))
        ){

            int character;
            while ((character = bufferedReader.read()) != -1) {
                bufferedWriter.write(character);
            }

            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
