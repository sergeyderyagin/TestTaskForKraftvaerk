package com.gmail.sergeyderyagin87;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver wd;
    public final Properties properties = new Properties();

    @BeforeClass(alwaysRun = true)
    public void setUp()  throws IOException {
        properties.load(new FileReader(new File("src/test/resources/properties")));
        goToSearchPage(properties.getProperty("searchSystemUrl"));
        search(properties.getProperty("findUrl"));
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    /**
     * Переход по URL поисковой системы.
     */
    public void goToSearchPage(String url) {
        wd = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get(url);
    }

    /**
     * Заполнение поисковой формы и выполнение поиска.
     */
    public void search(String request) {
        WebElement element = wd.findElement(By.name("q"));
        element.sendKeys(request);
        element.submit();
    }

}