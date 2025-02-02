package com.demosqa.drivers.strategies;

import com.demosqa.drivers.managers.ChromeDriverManager;
import com.demosqa.drivers.managers.FirefoxDriverManager;
import com.demosqa.drivers.utils.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverStrategyImplementer implements IDriverStrategy {

    @Override
    public WebDriver setStrategy(String strategy) {
        switch (strategy) {
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
            case BrowserType.FIREFOX:
                return FirefoxDriverManager.make();
            default:
                return ChromeDriverManager.make();

        }
    }
}