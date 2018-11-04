package com.teamone.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFormat {

    public void writeToCsv(ArrayList<Vehicle> vehicles) throws ExceptionAppLayer {

        try {
            String csvFile = "src/main/resources/output.csv";
            FileWriter writer = new FileWriter(csvFile);

            CSVUtils.writeLine(writer, Arrays.asList("Plate", "Expiration Date"));

            List<String> list;
            for (Vehicle vehicle : vehicles) {
                list = new ArrayList<>();
                list.add(vehicle.getPlate());
                list.add(vehicle.getEndDate());
                CSVUtils.writeLine(writer, list);
            }
            writer.flush();
            writer.close();
        } catch ( IOException exe){
            throw new ExceptionAppLayer("CsvFormat writeToCsv", exe);
        }
    }
}
