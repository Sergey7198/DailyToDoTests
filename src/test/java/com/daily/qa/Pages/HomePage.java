package com.daily.qa.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


public class HomePage {

    public static HomePage page() {
        return Selenide.page(HomePage.class);
    }

    public static HomePage open() {
        return Selenide.open("https://dailytodo.org/", HomePage.class);
    }

    @FindBy(xpath = "//A[@href='/'][text()='DailyTodo.org']")
    private SelenideElement pageTitle;

    @FindBy(xpath = "//IMG[@src='/dailytodo-home.png']")
    private SelenideElement imageSample;

    @FindBy(css = "[alt='Daily Todo Screenshot']")
    private SelenideElement altImage;

    @FindBy(css = "[value= 'Create your Daily Todo list']")
    private SelenideElement createDailyListButton;

    @FindBy(xpath = "//TABLE[@id='tasktable']")
    private SelenideElement tableWithTasks;

    @FindBy(xpath = "//TD[@id='t1']")
    private SelenideElement firstGoalInTable;

    @FindBy(xpath = "//TD[@id='t2']")
    private SelenideElement secondGoalInTable;

    @FindBy(xpath = "//A[@href='?edit=1'][text()='Edit']")
    private SelenideElement editGoalsButton;

    @FindBy(xpath = "//INPUT[@id='check1']")
    private SelenideElement markGoalAsCompletedCheckbox;

    @FindBy(xpath = "//B[@id='today1']")
    private SelenideElement unmarkFirstGoal;

    @FindBy(css = "[id='tasktable'] tbody tr")
    private ElementsCollection listOfTasks;

    public void clickToCreateGoalsButton() {
        createDailyListButton.shouldBe(Condition.enabled).click();
    }

    public void clickEditGoalsButton() {
        editGoalsButton.shouldBe(Condition.enabled).click();
    }

    public void clickToMarkGoalAsCompletedCheckbox() {
        markGoalAsCompletedCheckbox.click();
    }

    public void clickToUnmarkFirstGoal() {
        unmarkFirstGoal.shouldBe(Condition.enabled).click();
    }

    public void assertTitleIsDisplayed() {
        pageTitle.shouldHave(Condition.text("DailyTodo.org"));
    }

    public void assertImageSampleIsDisplayed() {
        imageSample.shouldBe(Condition.visible);
    }

    public void assertImageIsDisplayed() {
        altImage.shouldBe(Condition.visible);
        altImage.isDisplayed();
    }

    public void assertTableWithTasksIsDisplayed() {
        tableWithTasks.shouldBe(Condition.visible);
    }

    public void assertFirstRowOfTableContainsGoal(String text) {
        firstGoalInTable.shouldHave(Condition.text(text));
    }

    public void assertSecondRowOfTableContainsGoal(String text) {
        secondGoalInTable.shouldHave(Condition.text(text));
    }

    public void assertGoalWasMarkedAsCompleted() {
        markGoalAsCompletedCheckbox.waitUntil(Condition.attribute("selected", "true"), 3000);
    }

    public void assertGoalWasUnmarked() {
        markGoalAsCompletedCheckbox.shouldHave(Condition.attribute("style", "display: none;"));
    }

    public void assertListOfTasksContainsAllAddedTasks(int number) {
            listOfTasks.shouldHaveSize(number);
    }
}
