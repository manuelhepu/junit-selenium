package com.example.junit_selenium;
import java.util.concurrent.TimeUnit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchIMDB {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() {
        //driver = new FirefoxDriver();

        Configuration.startMaximized =true;
        open("about:blank");
        driver = getWebDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void imdb() {
        driver.get("https://www.imdb.com/");
        driver.manage().window().setSize(new Dimension(1107, 692));
        driver.findElement(By.id("suggestion-search")).click();
        driver.findElement(By.id("suggestion-search")).sendKeys("wandavision");
        //Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        /*try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            //handle the exception
        }*/

        driver.findElement(By.id("suggestion-search")).sendKeys(Keys.ENTER);
        /*try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            //handle the exception
        }*/
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.linkText("WandaVision")).click();
    }
}
