package com.daily.qa.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class AddGoalsPage {

    public static AddGoalsPage page() {
        return Selenide.page(AddGoalsPage.class);
    }
    public static AddGoalsPage open() {
        return Selenide.open("https://dailytodo.org/create", AddGoalsPage.class);
    }

    @FindBy(css = "[name='tasks']")
    private SelenideElement createNewTasksField;

    @FindBy(css = "body > div > form > p > a")
    private SelenideElement cancelButton;

    @FindBy(xpath = "//INPUT[@type='submit']")
    private SelenideElement submitGoalsButton;

    public void setSomeGoals(String text) {
        createNewTasksField.sendKeys(text);
    }

    public void rewriteExistingGoals(String text) {
        createNewTasksField.setValue(text);
    }

    public void clickSaveGoalsButton() {
        submitGoalsButton.shouldBe(Condition.enabled).click();
    }

    public void clickCancelButton(){
        cancelButton.shouldBe(Condition.enabled).click();
    }

    public void pressEnterButtonToMoveToTheNexRaw() {
        createNewTasksField.sendKeys(Keys.ENTER);
    }

    public void assertTaskFieldIsEnabled() {
        createNewTasksField.shouldBe(Condition.visible);
        createNewTasksField.shouldBe(Condition.enabled);
    }


}
