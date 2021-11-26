package com.epam.tc.hw7.entities;

import com.jdiai.tools.DataClass;
import java.util.Arrays;
import java.util.List;

public class MetalsAndColors extends DataClass<MetalsAndColors> {
    public List<String> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    public List<String> toListString() {
        return Arrays.asList("Summary: " + (Integer.parseInt(summary.get(0)) + Integer.parseInt(summary.get(1))),
            "Elements: " + Arrays.toString(new List[] {elements}).replaceAll("[\\[\\]]", ""),
            "Color: " + color,
            "Metal: " + metals,
            "Vegetables: " + Arrays.toString(new List[] {vegetables}).replaceAll("[\\[\\]]", ""));
    }
}
