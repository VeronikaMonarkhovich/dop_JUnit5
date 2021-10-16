package com.taory.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OzTestPage {
    public static final String URL = "https://oz.by//";
    private SelenideElement searchInput = $("#top-s");

    public OzResultsPage doSearch(String searchQuery) {
        searchInput.setValue(searchQuery).pressEnter();
        return new OzResultsPage();
    }
}
