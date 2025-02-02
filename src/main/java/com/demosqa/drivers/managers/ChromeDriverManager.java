package com.demosqa.drivers.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {
    public static WebDriver make(){
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}