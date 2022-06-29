package com.accesshq.planets;

import com.accesshq.model.NavBar;
import com.accesshq.model.Planet;
import com.accesshq.model.PlanetPage;
import com.accesshq.strategies.MatchingStrategy;
import com.accesshq.strategies.RadiusmatchingStrategy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestPlaygroundSuite {

    private WebDriver driver;
    @BeforeEach
    public void setup(){

        driver= new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");

    }
    public void exploreByName(String name){
        driver.findElement(By.cssSelector("a[aria-label='planets']")).click();

        var explore =new Planet(driver);
        explore.clickEarth(name);
        String s= explore.getMessage();
        Assertions.assertEquals("Exploring Earths",s);

    }
    public void exploreByRadius(){

        driver.findElement(By.cssSelector("a[aria-label='planets']")).click();
        var explore =new Planet(driver);
        WebElement f=findRadius();
        clickExplore((MatchingStrategy) f);

    }

    @Test
    public void verifyExploreSaturn(){
        new NavBar(driver).clickPlants();
        var planetPage=new PlanetPage(driver);
        planetPage.clickExplore(new RadiusmatchingStrategy(58238));
        Assertions.assertEquals("Exploring Saturn",planetPage.getPopupText());

    }
    private List<WebElement> clickExplore(MatchingStrategy strategy) {
        for(Planet planet : getPlanets()){
            if(strategy.match(planet)){
                planet.clickExplore();
            }
        }
        f.click();
    }

    private Planet getPlanets() {
        return (Planet) driver.findElements(By.cssSelector("planets"));
    }

    private WebElement findRadius() {
        for (WebElement planet:driver.findElements(By.cssSelector("dd[class='radius']"))) {
            String[] rad=planet.getText().split(" ");
            if(rad[0].equalsIgnoreCase("58232")){
                return driver.findElement(By.tagName("button"));
            }
        }
        return null;
    }

    @AfterEach
    public void fin(){
   //    driver.quit();
    }
}
