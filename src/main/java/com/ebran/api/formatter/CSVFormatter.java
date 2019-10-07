package com.ebran.api.formatter;

import com.ebran.api.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CSVFormatter {

    public static String format(Object obj) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema columns = mapper.schemaFor(Employee.class);
        try {
            return mapper.writer(columns).writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }
}
