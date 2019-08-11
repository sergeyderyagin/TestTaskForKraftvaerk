package com.gmail.sergeyderyagin87;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResults  {
    public List<WebElement> returnSearchResults() {

        WebElement searchResults = wd.findElement(By.className("srg"));
        List<WebElement> results = searchResults.findElements(By.className("g"));
        return results.get(Integer.valueOf(position) - 1).findElement(By.className("iUh30")).getText().equals(findUrl);
    }
}
