package com.simbirsoft.allure.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AnnotatedTestSteps {

    @Step("Открываем главную страницу GitHub")
    public AnnotatedTestSteps openGitHubMainPage() {
        open("");
        takeScreenshot();
        return this;
    }

    @Step("Делаем поиск репозитория {repository}")
    public AnnotatedTestSteps findRepo(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").setValue("selenide");
        $(".header-search-input").submit();
        takeScreenshot();
        return this;
    }

    @Step("Открываем репозиторий {repoName}")
    public AnnotatedTestSteps goToRepo(String repoName) {
        $(linkText(repoName)).click();
        takeScreenshot();
        return this;
    }

    @Step("Открываем раздел Issues")
    public AnnotatedTestSteps goToIssues() {
        $(partialLinkText("Issues")).click();
        takeScreenshot();
        return this;
    }

    @Step("Проверяем наличие Issue с именем {issueName}")
    public AnnotatedTestSteps checkIfIssueIsPresent(String issueName) {
        $(byText(issueName)).should(Condition.visible);
        takeScreenshot();
        return this;
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
