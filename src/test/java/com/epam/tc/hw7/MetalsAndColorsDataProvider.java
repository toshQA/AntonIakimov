package com.epam.tc.hw7;

import com.epam.tc.hw7.entities.MetalsAndColors;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class MetalsAndColorsDataProvider {

    @DataProvider(name = "Metals And Colors Provider")
    public static Object[][] getData() throws FileNotFoundException {
        JsonElement jsonData = JsonParser.parseReader(new FileReader("src/test/resources/com.epam.tc.hw7/JDI_ex8_metalsColorsDataSet.json"));
        List<MetalsAndColors> testData = new ArrayList<>();

        for (Map.Entry<String, JsonElement> element : jsonData.getAsJsonObject().entrySet()) {
            System.out.println(element);
            testData.add(new Gson().fromJson(element.getValue(), MetalsAndColors.class));
        }

        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
