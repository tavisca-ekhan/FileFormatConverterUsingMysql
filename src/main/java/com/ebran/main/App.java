package com.ebran.main;

import com.ebran.api.data.MysqlResult;
import com.ebran.api.file.FileHandler;
import com.ebran.api.formatter.CSVFormatter;
import com.ebran.api.formatter.JSONFormatter;
import com.ebran.api.formatter.XMLFormatter;
import com.ebran.api.model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        ArrayList<Employee> allEmployee = getEmployees();

        HashMap<Integer, Runnable> map = new HashMap<Integer, Runnable>() {{
           put(1, () -> jsonHandler(allEmployee));
           put(2, () -> xmlHandler(allEmployee));
           put(3, () -> csvHandler(allEmployee));
        }};


        while(true){
            displayConsoleMessage();
            int selectedOption = in.nextInt();

            if (!map.containsKey(selectedOption)) break;

            map.get(selectedOption).run();
        }
    }

    private static void csvHandler(ArrayList<Employee> allEmployee) {
        System.out.println("Please Enter the Path of File");
        String path = in.next();
        FileHandler handler = new FileHandler(path, "csv");
        String csvString = CSVFormatter.format(allEmployee);

        try {
            handler.createNewFile();
            handler.writeToFile(csvString);
            System.out.println("Created File "+ handler.getFullPathOfTheNewCreatedFile()+ " and inserted Data\n\n\n");
        } catch (IOException e) {
            System.out.println("Unable to Create File in The Specified Path Please Try Again\n\n\n");
        }
    }

    private static void xmlHandler(ArrayList<Employee> allEmployee) {
        System.out.println("Please Enter the Path of File");
        String path = in.next();
        FileHandler handler = new FileHandler(path,"xml");
        String xmlString = XMLFormatter.format(allEmployee);

        try {
            handler.createNewFile();
            handler.writeToFile(xmlString);
            System.out.println("Created File "+ handler.getFullPathOfTheNewCreatedFile() + " and inserted Data\n\n\n");
        } catch (IOException e) {
            System.out.println("Unable to Create File in The Specified Path Please Try Again\n\n\n");
        }
    }

    private static void jsonHandler(ArrayList<Employee> allEmployee) {
        System.out.println("Please Enter the Path of File");
        String path = in.next();

        FileHandler handler = new FileHandler(path, "json");
        String jsonString = JSONFormatter.format(allEmployee);

        try {
            handler.createNewFile();
            handler.writeToFile(jsonString);
            System.out.println("Created File "+ handler.getFullPathOfTheNewCreatedFile() + " and inserted Data\n\n\n");
        } catch (IOException e) {
            System.out.println("Unable to Create File in The Specified Path Please Try Again\n\n\n");
        }
    }

    private static ArrayList<Employee> getEmployees() {
        MysqlResult mysqlRepository = new MysqlResult();
        return mysqlRepository.getAllEmployees();
    }

    private static void displayConsoleMessage() {
        System.out.println("1. Get The Data In JSON Format\n" +
                "2. Get The Data In XML Format\n" +
                "3. Get The Data in CSV Format\n" +
                "4. Exit \n" );
    }
}
