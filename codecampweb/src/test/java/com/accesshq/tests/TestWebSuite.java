package com.accesshq.tests;

import com.accesshq.forms.Model.Form;
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

    public static class TestFormsSuite {

        private WebDriver driver;

        @BeforeEach
        public void setup(){

            driver= new ChromeDriver();
            driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/forms");

        }
        @Test
        public void fill_forms(){

            driver.findElement(By.cssSelector("a[aria-label='forms']"));
            var form =new Form(driver);
            form.setName("Deepthy");
            form.setEmail("deepthy.joseph@accesshq.com");
            form.setState("WA");
            form.clickAgree();
            form.clickSubmit();
            String s= form.getMessage();
            Assertions.assertEquals("Thanks for your feedback Deepthy",s);
        }
        @AfterEach
        public void fin(){
            driver.quit();
        }


    }
}
