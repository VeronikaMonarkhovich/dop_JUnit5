package com.taory;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.taory.page.OzTestPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith({SimpleCallback.class})

public class OzTest extends TestBase{
    private OzTestPage page = new OzTestPage();
    @ValueSource(strings = {
            "кружка",
            "ежедневник",
            "ручка",
            "настольная игра"
    })

    @ResourceLock("1")
    @ParameterizedTest(name = "Проверка результатов поиска: {0}")
    void testWithName(String searchQuery) {
        Configuration.startMaximized = true;
        Selenide.open(OzTestPage.URL);
        page.doSearch(searchQuery).checkResults(searchQuery);
        System.out.println("В результатах присутствует: " + searchQuery);
    }

    @ResourceLock("1")
    @DisplayName("Проверка результатов поиска: чай")
    @Test
    void minimizedWindowTest() {
        Configuration.startMaximized = false;
        Selenide.open(OzTestPage.URL);
        page.doSearch("чай")
                .checkResults("чай");
        System.out.println("В результатах присутствует: чай");
    }
}
