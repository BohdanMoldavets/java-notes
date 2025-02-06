package org.moldavets.IO_NIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample1 {
    public static void main(String[] args) {

        List<String> namesEmployees = new ArrayList<>();

        namesEmployees.add("John");
        namesEmployees.add("Katy");
        namesEmployees.add("Susan");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CopyExample.PROJECT_PATH + "names.bin"))) {

            oos.writeObject(namesEmployees);
            System.out.println("done");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
