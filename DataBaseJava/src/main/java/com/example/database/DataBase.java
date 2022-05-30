
package com.example.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * DataBase class
 * @author Gurabtov Vladislav
 */
public class DataBase {
    /**
     * list of objects
     */
    public ObservableList<Person> objects;

    /**
     * constructor with params
     */
    DataBase() {
        objects = FXCollections.observableArrayList();
    }

    /**
     * read data from file
     * @param fileName name of file
     * @throws IOException if file not opened
     */
    public void readFile(String fileName) throws IOException {

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                Person s = new Person();
                String[] split = line.split(", ");
                s.setParams(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                objects.add(s);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * saving data in file
     * @param fileName name of file
     */
    public void saveFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Person object : objects) {
                String text = object.toString() + "\n";
                writer.write(text);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
