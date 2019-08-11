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
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public WebDriver wd;
    public final Properties properties = new Properties();

    @BeforeClass(alwaysRun = true)
    public void setUp()  throws IOException {
        properties.load(new FileReader(new File("src/test/resources/properties")));
        goToSearchPage(properties.getProperty("searchSystemUrl"));
        makeSearch(properties.getProperty("findUrl"));
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }


    public void goToSearchPage(String url) {
        wd = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get(url);
    }

    public void makeSearch(String request) {
        WebElement element = wd.findElement(By.name("q"));
        element.sendKeys(request);
        element.submit();
    }

    public boolean checkLinkFromResults(String findUrl, String position) {
        WebElement searchResults = wd.findElement(By.className("srg"));
        List<WebElement> results = searchResults.findElements(By.className("g"));
        return results.get(Integer.valueOf(position) - 1).findElement(By.className("iUh30")).getText().equals(findUrl);
    }
}
