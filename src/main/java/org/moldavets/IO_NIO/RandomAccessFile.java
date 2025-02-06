package org.moldavets.IO_NIO;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RandomAccessFile {
    public static void main(String[] args) {
        try (java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(CopyExample.PROJECT_PATH + "file1.txt","rw")) {

            randomAccessFile.seek(1);
            int a = randomAccessFile.read();
            System.out.println((char)a);

            String b = randomAccessFile.readLine();
            System.out.println(b);



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
