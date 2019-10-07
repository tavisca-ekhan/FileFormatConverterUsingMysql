package com.ebran.api.formatter;

import com.ebran.api.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XMLFormatter {

    public static String format(Object obj) {
        try {
            ObjectMapper xmlMapper = new XmlMapper();
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return xmlMapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void serializeXML(Employee employee) throws IOException {
        FileOutputStream out = new FileOutputStream("data.xml");
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(out));
        encoder.writeObject(employee);
        encoder.close();
        out.close();
    }

    public static void serializeXML(ArrayList<Employee> employeeArrayList) throws IOException {
        Employee[] employees = employeeArrayList.toArray(new Employee[employeeArrayList.size()]);
        FileOutputStream out = new FileOutputStream("data.xml");
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(out));
        encoder.writeObject(employees);
        encoder.close();
        out.close();
    }
}
