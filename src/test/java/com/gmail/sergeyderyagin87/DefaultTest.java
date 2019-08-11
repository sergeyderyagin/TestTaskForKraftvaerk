package com.gmail.sergeyderyagin87;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DefaultTest extends TestBase {

    @Test
    public void testCheckPositionFromResults(){
        assertTrue(
                checkLinkFromResults(properties.getProperty("findUrl"), properties.getProperty("position")),
                properties.getProperty("findUrl") + " not found in position " +  properties.getProperty("position"));

    }

}
