package com.accesshq.web;

import com.google.errorprone.annotations.Var;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestWebSuite {

    private WebDriver driver;

    @BeforeEach
    public void setup(){

        driver= new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
    }

    @Test
    public void testLoc(){
        String name = "Deepthy";
        driver.findElement(By.id("forename")).sendKeys(name);
        driver.findElement(By.id("submit")).click();
        WebElement popup_msg=driver.findElement(By.className("popup-message"));
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(popup_msg));
        Assertions.assertEquals("Hello "+name,popup_msg.getText());
       }

    @AfterEach
    public void finish(){
        driver.quit();
    }
}
