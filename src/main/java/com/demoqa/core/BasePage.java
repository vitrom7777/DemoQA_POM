package com.demoqa.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public abstract class BasePage {
    public static JavascriptExecutor js;
    protected WebDriver driver;
    public static SoftAssertions softly;
    public Actions actions;

    //public  Action actions;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        softly = new SoftAssertions();
        actions = new Actions(driver);


    }

    public void click(WebElement element) {
        // 25 - wait click
        getWait(5).until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    public void clickWithJS(WebElement element, int x, int y) {
        scrollWithJS(x, y);
        click(element);
    }

    public void typeWithJS(WebElement element, String text, int x, int y) {
        scrollWithJS(x, y);
        type(element, text);
    }

    public void scrollWithJS(int x, int y) {
        pause(1000);
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }


    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.click();
            element.sendKeys(text);
        }
    }

    public boolean isAlertPresent(int time) {
        Alert alert = getWait(time)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;

        }

    }

    public WebDriverWait getWait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public boolean isContainsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWait(time).until(ExpectedConditions
                .textToBePresentInElement(element, text));
    }

    // zdat' vidimymost elementa
    public void waitOfElementVisibility(WebElement element, int time) {
        getWait(time)
                .until(ExpectedConditions
                        .visibilityOf(element));
    }

    public String getValue(WebElement element, String value) {
        return element.getDomAttribute(value);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.getMessage();
            //throw new RuntimeException(e);
            return false;
        }
    }

    public void verifyLinks(String url) {
        try {
            URL linkUrl = new URL(url);
            //create URL connection and get response code < 400 gut
            HttpURLConnection  connection = (HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            int statusCode = connection.getResponseCode();
            if (statusCode>= 400) {
               // System.out.println(url+"-->"+connection.getResponseMessage()+"is a BROKEN URL");
           softly.fail(url+"-->"+connection.getResponseMessage()+"is a BROKEN URL");
            } else  {
               // System.out.println(url+"-->" +connection.getResponseMessage());
            softly.assertThat(statusCode).isLessThan(400);
            }
        } catch (IOException e) {
           // System.out.println(url + "-->" + "ERROR occurred");
         softly.fail(url + "-->" + "ERROR occurred");
        }


    }
    public void clickWithRectangle(WebElement element){
        Rectangle rectangle = element.getRect();
        int xOffset = rectangle.getWidth() / 4; //  or /6
        int yOffset = rectangle.getHeight() / 2;
        actions.moveToElement(element).perform();
        actions.moveByOffset(-xOffset,-yOffset).click().perform();




    }
}
