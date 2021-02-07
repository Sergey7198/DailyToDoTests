package com.daily.qa.Tests;

import com.daily.qa.Pages.*;
import com.daily.qa.helpers.TestBase;
import org.testng.annotations.*;

public class DailyTodoTest extends TestBase {

    @Test(description = "Try to create 3 goals and check if list of goals is displayed and has 3 elements")
    public void checkIfUserCanAddNewGoals() {

        HomePage homePage = HomePage.open();

        homePage.assertTitleIsDisplayed();
        homePage.assertImageSampleIsDisplayed();
        homePage.assertImageIsDisplayed();
        homePage.clickToCreateGoalsButton();

        AddGoalsPage addGoalsPage = AddGoalsPage.page();
        addGoalsPage.assertTaskFieldIsEnabled();
        addGoalsPage.setSomeGoals("Goal Number One");
        addGoalsPage.pressEnterButtonToMoveToTheNexRaw();
        addGoalsPage.setSomeGoals("Set second goal Test");
        addGoalsPage.pressEnterButtonToMoveToTheNexRaw();
        addGoalsPage.setSomeGoals("Third goal also should be set");
        addGoalsPage.clickSaveGoalsButton();

        homePage.assertListOfTasksContainsAllAddedTasks(3);
        homePage.assertTableWithTasksIsDisplayed();
        homePage.assertFirstRowOfTableContainsGoal("Goal Number One");
    }

    @Test(description = "Create new goal and check if user can mark it as done and uncheck this goal")
    public void checkIfUserCanMarkAndUnmarkDoneGoals() {
        HomePage homePage = HomePage.open();
        homePage.assertTitleIsDisplayed();
        homePage.clickToCreateGoalsButton();

        AddGoalsPage addGoalsPage = AddGoalsPage.page();
        addGoalsPage.assertTaskFieldIsEnabled();
        addGoalsPage.setSomeGoals("Goal Number One");
        addGoalsPage.clickSaveGoalsButton();

        homePage.assertTableWithTasksIsDisplayed();
        homePage.assertFirstRowOfTableContainsGoal("Goal Number One");
        homePage.clickToMarkGoalAsCompletedCheckbox();
        homePage.assertGoalWasMarkedAsCompleted();
        homePage.clickToUnmarkFirstGoal();
        homePage.assertGoalWasUnmarked();
    }

    @Test(description = "Create some goals and check if user can edit them")
    public void checkIfUserCanEditHisGoals() {
        HomePage homePage = HomePage.open();
        homePage.assertTitleIsDisplayed();
        homePage.assertImageIsDisplayed();
        homePage.clickToCreateGoalsButton();

        AddGoalsPage addGoalsPage = AddGoalsPage.page();
        addGoalsPage.assertTaskFieldIsEnabled();
        addGoalsPage.setSomeGoals("Goal Number One");
        addGoalsPage.clickSaveGoalsButton();

        homePage.assertTableWithTasksIsDisplayed();
        homePage.assertFirstRowOfTableContainsGoal("Goal Number One");
        homePage.clickEditGoalsButton();
        addGoalsPage.assertTaskFieldIsEnabled();
        addGoalsPage.setSomeGoals("Simple Test Goal After Editing");
        addGoalsPage.clickSaveGoalsButton();

        homePage.assertListOfTasksContainsAllAddedTasks(2);
        homePage.assertFirstRowOfTableContainsGoal("Goal Number One");
        homePage.assertSecondRowOfTableContainsGoal("Simple Test Goal After Editing");
    }

    @Test(description = "Check that after clicking the 'Cancel' button system doesn't save the edited goal ")
    public void checkIfGoalsAreNotSavedAfterClickingCancelButton(){
        HomePage homePage = HomePage.open();

        homePage.clickToCreateGoalsButton();

        AddGoalsPage addGoalsPage = AddGoalsPage.page();
        addGoalsPage.assertTaskFieldIsEnabled();
        addGoalsPage.setSomeGoals("Goal Number One");
        addGoalsPage.clickSaveGoalsButton();

        homePage.assertTableWithTasksIsDisplayed();
        homePage.assertFirstRowOfTableContainsGoal("Goal Number One");
        homePage.clickEditGoalsButton();

        addGoalsPage.assertTaskFieldIsEnabled();
        addGoalsPage.rewriteExistingGoals("Some test");
        addGoalsPage.clickCancelButton();

        homePage.assertTableWithTasksIsDisplayed();
        homePage.assertFirstRowOfTableContainsGoal("Goal Number One");
        homePage.assertListOfTasksContainsAllAddedTasks(1);
    }


}
