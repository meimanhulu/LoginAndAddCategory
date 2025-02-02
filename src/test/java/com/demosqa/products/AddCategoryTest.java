package com.demosqa.products;

import com.demosqa.drivers.DriverSingleton;
import com.demosqa.drivers.utils.BrowserType;
import com.demosqa.pages.products.CategoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddCategoryTest {
    private CategoryPage categoryPage;
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("Category Test");
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
    }

    @Test(dependsOnMethods= {"signInPositiveTest"})
    public void addCategoryPositiveTest() {
        System.out.println("Positive Test Add Category");
        //driver.get("http://127.0.0.1:8000/admin/products/category/add/");
        categoryPage = new CategoryPage(driver);
        categoryPage.clickGoToCategory();
        categoryPage.waitForCategoryElement();
        categoryPage.addCategoryActivity("Makanan");

        String expected = "The category “Makanan” was added successfully.";
        String actual = categoryPage.getSuccessMessageAddCategory();

        Assert.assertEquals(actual.toLowerCase(), expected.toLowerCase());
    }
}