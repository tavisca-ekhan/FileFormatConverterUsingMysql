package com.ebran.main;

import com.ebran.api.data.MysqlResult;
import com.ebran.api.formatter.CSVFormatter;
import com.ebran.api.formatter.JSONFormatter;
import com.ebran.api.formatter.XMLFormatter;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MysqlResult result = new
                MysqlResult();
        Scanner in = new
                Scanner(System.in);
        while(true){

            System.out.println("1. Get The Data In JSON Format\n" +
                    "2. Get The Data In XML Format\n" +
                    "3. Get The Data in CSV Format\n" +
                    "4. Exit \n" );

            int option = in.nextInt();

            switch (option){
                case 1 :{
                    String jsonFormat = JSONFormatter.format(result.getAllEmployees());
                    System.out.println(jsonFormat+"\n\n\n");
                    break;
                }

                case 2 :{
                    String xmlFormat = XMLFormatter.format(result.getAllEmployees());
                    System.out.println(xmlFormat+"\n\n\n");
                    break;
                }

                case 3 :{
                    String csvFormat = CSVFormatter.format(result.getAllEmployees());
                    System.out.println(csvFormat+"\n\n\n\n");
                    break;
                }

                case 4 :{
                    System.out.println("----------------------Thank You ---------------------------");
                    return;
                }

                default: {
                    System.out.println("Make a Valid Selection ");
                }
            }
        }
    }
}
