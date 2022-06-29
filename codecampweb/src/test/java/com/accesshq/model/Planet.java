package com.accesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Planet {

    private WebDriver driver;


    public Planet(WebDriver driver) {
        this.driver= driver;
    }

    public void clickEarth(String planets) {
   /*     for (WebElement sel:driver.findElements(By.cssSelector("ul[class='planets'] li"))) {

            if(sel.findElement(By.tagName("h2")).getText().equalsIgnoreCase("Earth")){
                sel.findElement(By.tagName("button")).click();
                break;
            }
        }*/
         for (Planet planet : getPlanets()) {
             if (planet.getName().getText().equalsIgnoreCase(planets)) {
                 planet.clickExplore();
                 waitForPopUpmessage();
                 break;
             }
         }
    }
    public String getMessage() {
        WebElement popup_msg=driver.findElement(By.className("popup-message"));
        return popup_msg.getText();
    }
}
