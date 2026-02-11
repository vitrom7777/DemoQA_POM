package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class iframesPage extends BasePage {

    //create constrictor
    public iframesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "frame1")
    WebElement frame1;
    @FindBy(css = "h1")
    WebElement title;

    @FindBy(css = "iframe")
    List<WebElement> iframes;

    public iframesPage switchToIframeById() {
        System.out.println(iframes.size());
        driver.switchTo().frame(frame1);
        return this;
    }

    public iframesPage verifyIframeByTitle(String text) {
        Assertions.assertTrue(isContainsText(text, title));
        return this;
    }

    public iframesPage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(css = ".text-center")
    WebElement mainTitle;

    public iframesPage verifyMainPageByTitle(String text) {
        Assertions.assertTrue(isContainsText(text, mainTitle));
        return this;
    }


    @FindBy(css = "body")
    WebElement body;

    public iframesPage verifyNestedIframes() {
        //switch to parent iframe by id
        driver.switchTo().frame(frame1);
//assert 1 by test and 2 by total numbers of iframes
        softly.assertThat(isContainsText("Parent frame", body));
        softly.assertThat(iframes.size()).isEqualTo(1);
//switch to child iframe by index
        driver.switchTo().frame(0);
//asset by text
        softly.assertThat(isContainsText("Child Iframe", body));
//return to parent iframe
        driver.switchTo().parentFrame();
//assert by text
        softly.assertThat(isContainsText("Parent frame", body));
        softly.assertAll();
        return this;
    }
}
