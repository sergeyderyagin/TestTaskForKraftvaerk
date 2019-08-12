package com.gmail.sergeyderyagin87;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Получение списка элементов на странице с результатами поиска.
 * Рекламные объявления не  рассматриваются как результаты поиска.
 */
public class DefaultTest extends SearchResults {

    @Test
    public void testCheckPositionFromResults(){
        int position = Integer.parseInt(properties.getProperty("position")) - 1;
        assertTrue(position >= 0, "Position must be greater than zero.");

        WebElement result = returnSearchResults().
                get(position); // -1 используем т.к. в ЯП отсчет элементов начинается с 0, а для пользователя удобней начинать с 1.

        assertEquals(
                result.findElement(By.className("iUh30")).getText(),
                properties.getProperty("findUrl"),
                properties.getProperty("findUrl") + " not found in position " + position);
    }

}
