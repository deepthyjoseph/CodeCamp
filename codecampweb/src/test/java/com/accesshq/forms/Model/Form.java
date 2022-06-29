package com.accesshq.forms.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Form {
    private final WebDriver driver;

    public Form(WebDriver driver) {
        this.driver=driver;
    }

    public void setName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void setEmail(String Email) {
        driver.findElement(By.id("email")).sendKeys(Email);
    }

    public void setState(String state) {
        driver.findElement(By.className("v-select__selections")).click();
        WebElement stateSel =driver.findElement(By.className("v-list-item__content"));
        new WebDriverWait(driver,2).until(ExpectedConditions.visibilityOf(stateSel));
        for (WebElement st : driver.findElements(By.className("v-list-item__content"))) {

            if(st.getText().equalsIgnoreCase(state)){
                st.click();
                break;
            }
        }
    }

    public void clickAgree() {
        driver.findElement(By.cssSelector("[for='agree']")).click();
    }

    public void clickSubmit() {
        for(WebElement curr : driver.findElements(By.tagName("button"))){
            if(curr.getText().equalsIgnoreCase("submit")){
                curr.click();
                break;
            }
        }
    }

    public String getMessage() {
        WebElement popup_msg=driver.findElement(By.className("popup-message"));
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(popup_msg));
        return popup_msg.getText();
    }


}
