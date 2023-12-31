package com.demoqa.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.google.common.base.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebDriverConfig config;

        public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.baseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        switch (config.getBrowser()) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default: {
                throw new RuntimeException("No such browser");
            }
        }

    }
}