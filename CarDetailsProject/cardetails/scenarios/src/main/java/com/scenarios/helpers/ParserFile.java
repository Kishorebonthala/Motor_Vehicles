package com.scenarios.helpers;

import com.scenarios.model.Vehicle;
import java.io.IOException;
import java.util.List;

public interface ParserFile {

    public List<Vehicle> toVehicles(String filePath) throws IOException;

}
