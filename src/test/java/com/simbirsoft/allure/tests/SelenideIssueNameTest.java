package com.simbirsoft.allure.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;
import static com.codeborne.selenide.Selectors.byText;

public class SelenideIssueNameTest extends TestBase {

    @Test
    public void selenideIssueNameTest() {

        open("");

        $(".header-search-input").click();
        $(".header-search-input").setValue("selenide");
        $(".header-search-input").submit();

        $(linkText("selenide/selenide")).click();
        $(partialLinkText("Issues")).click();

        $(byText("Sonarqube plugin is not applied to subrojects")).should(Condition.visible);
        $(byText("Allow clear localstorage\\cookies for all domains in Chromium via devtools.")).should(Condition.visible);
        $(byText("Add methods to copy and paste content")).should(Condition.visible);
        $(byText("Make clipboard work even in headless mode")).should(Condition.visible);
        $(byText("Selenide plugins can inject default implementation & other plugins")).should(Condition.visible);
    }
}
