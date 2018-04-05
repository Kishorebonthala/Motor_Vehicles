package com.scenarios.helpers;

import com.scenarios.model.Vehicle;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseCSVFiles implements ParserFile {

    @Override
    public List<Vehicle> toVehicles(String filePath) throws IOException {

        List<Vehicle> results = new ArrayList<>();

        try {

            CsvReader vehicles = new CsvReader(filePath);

            vehicles.readHeaders();

            while (vehicles.readRecord()) {

                    results.add(Vehicle.createVehicle(
                            vehicles.get("Registration number"),
                            vehicles.get("make"),
                            vehicles.get("colour")));


            }
            vehicles.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }
}