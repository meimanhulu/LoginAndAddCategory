package com.demosqa.pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {
    private WebDriver driver;

    //@FindBy(xpath = "//*[@id=\"content\"]/h1='Select category to change']")
    @FindBy(xpath = "//h1[normalize-space()='Select category to change']")
    private WebElement categoryElement;

    @FindBy(xpath = "//a[normalize-space()='Categorys']")
    private WebElement goToCategory;

    @FindBy(xpath = "//a[normalize-space()='Add category']")
    private WebElement addCategoryButton;

    @FindBy(xpath = "//*[@id=\"id_name\"]")
    private WebElement fillNameCategory;

    @FindBy(xpath = "//*[@id=\"category_form\"]/div/div/input[1]")
    WebElement buttonSaveCategoryElement;

    @FindBy(xpath = "//*[@id=\"searchbar\"]")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"changelist-search\"]/div/input[2]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"content-start\"]/ul/li")
    private WebElement addCategorySuccess;

    private WebDriverWait wait;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void waitForCategoryElement() {
        By locator = By.xpath("//h1[normalize-space()='Select category to change']");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickGoToCategory(){
        goToCategory.click();
    }

    public void clickAddCategory(){
        addCategoryButton.click();
    }

    public void fillCategory(String nameCategory) {
        fillNameCategory.sendKeys(nameCategory);
    }

    public void clickSaveCategory(){
        buttonSaveCategoryElement.click();
    }

    public void addCategoryActivity(String nameCategory) {
        clickAddCategory();
        fillCategory(nameCategory);
        clickSaveCategory();
    }

    public String getSuccessMessageAddCategory() {
        return addCategorySuccess.getText();
    }
}