package com.epam.tc.hw7;

import static java.util.Objects.requireNonNull;

import com.epam.tc.hw7.entities.MetalsAndColors;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.testng.annotations.DataProvider;

public class MetalsAndColorsDataProvider {

    @DataProvider(name = "Metals And Colors Provider")
    public Object[][] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("/Users/Anton_Iakimov"
            + "/work/Java_automation/AntonIakimov"
            + "/src/test/resources/com.epam.tc.hw7/JDI_ex8_metalsColorsDataSet.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<MetalsAndColors> testData = new Gson().fromJson(dataSet, new TypeToken<List<MetalsAndColors>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

}
