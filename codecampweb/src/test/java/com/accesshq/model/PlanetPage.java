package com.accesshq.model;

import com.accesshq.strategies.RadiusmatchingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanetPage {
    public PlanetPage(WebDriver driver) {
        this.driver= driver;
    }

    public String getPopupText() {
        WebElement popup_msg=driver.findElement(By.className("popup-message"));
        return popup_msg.getText();
    }

    public void clickExplore(RadiusmatchingStrategy radiusmatchingStrategy) {

    }
}
