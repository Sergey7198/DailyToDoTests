package com.daily.qa.helpers;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class TestBase {
    private RemoteWebDriver driver;

    @BeforeMethod(alwaysRun=true)
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        driver = new ChromeDriver(chromeOptions);
        WebDriverRunner.setWebDriver(driver);
    }
    @AfterMethod(alwaysRun=true)
    public void tearDown() {
        driver.quit();
    }
}

