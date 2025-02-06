package org.moldavets.IO_NIO;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample2 {
    public static void main(String[] args) {
        EmployeeModel employee = new EmployeeModel("Bohdan", "IT", 18, 5000);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CopyExample.PROJECT_PATH  + "employee.bin"))) {

            oos.writeObject(employee);
            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
