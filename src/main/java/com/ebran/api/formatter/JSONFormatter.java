package com.ebran.api.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JSONFormatter {

    public static String format(Object input) {

        ObjectMapper obj = new ObjectMapper();
        String result = "";

        try {
            result = obj.writerWithDefaultPrettyPrinter().writeValueAsString(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
