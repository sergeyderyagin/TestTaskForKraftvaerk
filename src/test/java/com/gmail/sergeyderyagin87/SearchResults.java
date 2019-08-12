package com.gmail.sergeyderyagin87;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResults  extends TestBase {
    public List<WebElement> returnSearchResults() {

        WebElement searchResults = wd.findElement(By.className("srg")); // Получение блока с результатами поиска, исключая рекламный блок
        return searchResults.findElements(By.className("g")); // Получение списка элементов из блока с результатами поиска.
    }
}
