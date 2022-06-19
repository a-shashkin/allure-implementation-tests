package com.simbirsoft.allure.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Feature("Issue репозиториев")
@Owner("Alexander Shashkin")
public class AnnotatedIssueNameTest extends TestBase {

    private final static String REPOSITORY = "selenide";
    private final static String REPO_LINK = "selenide/selenide";

    @Test
    @Story("Поиск Issue по названию")
    @DisplayName("Проверка наличия Issue с указанными названиями на странице Issues репозитория")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Главная страница", url = "https://github.com/")
    public void selenideIssueNameTest() {

        AnnotatedTestSteps steps = new AnnotatedTestSteps();

        steps.openGitHubMainPage()
             .findRepo(REPOSITORY)
             .goToRepo(REPO_LINK)
             .goToIssues()
             .checkIfIssueIsPresent("Sonarqube plugin is not applied to subrojects")
             .checkIfIssueIsPresent("Allow clear localstorage\\cookies for all domains in Chromium via devtools.")
             .checkIfIssueIsPresent("Add methods to copy and paste content")
             .checkIfIssueIsPresent("Make clipboard work even in headless mode")
             .checkIfIssueIsPresent("Selenide plugins can inject default implementation & other plugins");

    }
}
