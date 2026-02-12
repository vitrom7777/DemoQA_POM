package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import com.demoqa.pages.alertsFrameWindows.iframesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsFrameWindowsTests extends TestBase {
    SidePanel sidePanel;
    AlertsPage alerts;
    iframesPage iframes;

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
        sidePanel = new SidePanel(driver);
        alerts = new AlertsPage(driver);
        iframes = new iframesPage(driver);
    }

    @Test
    public void waitAlertsTest() //Zdem alert
    {
        sidePanel.getAlerts();
        alerts.verifyAlertWithTimer();
    }

    @Test
    public void alertWithSelectResult() //alert s potverzdeniem ok - cansel
    {
        sidePanel.getAlerts();
        alerts.clickOnResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void sendMessagesToAlertTest()  //ogda nado v alert vvodit' text
    {
        sidePanel.getAlerts();
        alerts.clickOnPromptButton()
                .sendMessageToAlert("Hello world!")
                .verifyMessage("Hello world!");

    }

    @Test // open new page in new window
    public void newTabTest() {
        sidePanel.getBrowserWindows();
        new WindowsPage(driver).clickNewTabButton()
                .switchToNewTab(1)
                .verifyNewTabTitle("This is a sample page");
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    @Test
    @Tag("smoky")
    public void iframeByIdTest() {
        sidePanel.getFrames();
        iframes.switchToIframeById()
                .verifyIframeByTitle("This is a sample page")
                .switchToMainPage()
                .verifyMainPageByTitle("Frames");
    }

    @Test
    public void nestedIframesTest() {
        sidePanel.getNestedFrames();
        iframes.verifyNestedIframes();
    }
}

