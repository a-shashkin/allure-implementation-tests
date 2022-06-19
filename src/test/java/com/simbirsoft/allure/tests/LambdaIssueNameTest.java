package com.simbirsoft.allure.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaIssueNameTest extends TestBase {

    private final static String REPOSITORY = "selenide";
    private final static String REPO_LINK = "selenide/selenide";

    @Test
    public void selenideIssueNameTest() {
        feature("Issue репозиториев");
        story("Поиск Issue по названию");
        Allure.label("owner", "Alexander Shashkin");
        Allure.label("severity", "blocker");
        Allure.link("Главная страница", "https://github.com/");

        step("Открываем главную страницу GitHub", () -> {
            open("");
            takeScreenshot();
        });

        step("Делаем поиск репозитория", () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
            takeScreenshot();
        });

        step("Открываем репозиторий", () -> {
            $(linkText(REPO_LINK)).click();
            takeScreenshot();
        });

        step("Открываем раздел Issues репозитория", () -> {
            $(partialLinkText("Issues")).click();
            takeScreenshot();
        });

        step("Проверяем наличие Issue с названием \"Sonarqube plugin is not applied to subrojects\"", () -> {
            $(byText("Sonarqube plugin is not applied to subrojects")).should(Condition.visible);
            takeScreenshot();
        });


        step("Проверяем наличие Issue с названием \"Allow clear localstorage\\cookies for all domains in Chromium via devtools.\"", () -> {
            $(byText("Allow clear localstorage\\cookies for all domains in Chromium via devtools.")).should(Condition.visible);
            takeScreenshot();
        });


        step("Проверяем наличие Issue с названием \"Add methods to copy and paste content\"", () -> {
            $(byText("Add methods to copy and paste content")).should(Condition.visible);
            takeScreenshot();
        });


        step("Проверяем наличие Issue с названием \"Make clipboard work even in headless mode\"", () -> {
            $(byText("Make clipboard work even in headless mode")).should(Condition.visible);
            takeScreenshot();
        });


        step("Проверяем наличие Issue с названием \"Selenide plugins can inject default implementation & other plugins\"", () -> {
            $(byText("Selenide plugins can inject default implementation & other plugins")).should(Condition.visible);
            takeScreenshot();
        });

    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
