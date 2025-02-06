package org.moldavets.IO_NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample2 {
    public static void main(String[] args) {

        EmployeeModel employeeModel;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CopyExample.PROJECT_PATH + "employee.bin"))) {

            employeeModel = (EmployeeModel) ois.readObject();
            System.out.println(employeeModel);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
