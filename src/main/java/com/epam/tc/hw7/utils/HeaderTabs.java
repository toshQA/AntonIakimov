package com.epam.tc.hw7.utils;

public enum HeaderTabs {

    Home("Home"),
    MetalsAndColors("Metals & Colors");

    private String headerTab;

    HeaderTabs(String headerTab) {
        this.headerTab = headerTab;
    }

    public String getHeaderTab() {
        return headerTab;
    }
}
