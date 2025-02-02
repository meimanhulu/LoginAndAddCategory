package com.demosqa.authentication;

import com.demosqa.drivers.DriverSingleton;
import com.demosqa.drivers.utils.BrowserType;
import com.demosqa.pages.authentications.DashboardPage;
import com.demosqa.pages.authentications.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.demosqa.HookTest;

public class SignInTestAdmin {
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("Sign In Test Admin");
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
    }

    @Test(priority = 1)
    public void signInNegativeTest() {
        System.out.println("Negative Test Login");
        HookTest.delay(5);
        driver.get("http://127.0.0.1:8000/admin");
        signInPage = new SignInPage(driver);
        signInPage.loginActivity("admin", "1234");
        HookTest.delay(3);

        String expected = "Please enter the correct username and password for a staff account. Note that both fields may be case-sensitive.";
        String actual = signInPage.getErrorMessage();

        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());

        HookTest.delay(5);
    }

    @Test(priority = 2)
    public void signInPositiveTest() {
        System.out.println("Positive Test Login");
        driver.get("http://127.0.0.1:8000/admin");
        signInPage = new SignInPage(driver);
        signInPage.loginActivity("admin", "admin");

        HookTest.delay(3);

        dashboardPage = new DashboardPage(driver);

        String expected = "Welcome to Demo SQA Testing Portal";
        String actual = dashboardPage.getTextWelocmeHeadingElement();

        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());
        HookTest.delay(5);
    }
}