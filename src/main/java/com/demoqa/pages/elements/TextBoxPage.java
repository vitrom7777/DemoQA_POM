package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    // kuda vvod
    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage copyPast(String address) {
        typeWithJS(currentAddress, address, 0, 400);
//select current address text
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//copy current address text
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
//press TAB to switch focus to permanent address field
        actions.sendKeys(Keys.TAB).perform();
//past current address text to permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        return this;
    }


    // Submit
    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage clickOnSubmitButton() {
        click(submit);
        return this;
    }

    @FindBy(css = ".border #currentAddress")
    //@FindBy(id = "currentAddress")
    WebElement currentAddressResult;
    @FindBy(css = ".border #permanentAddress")
    //@FindBy(id = "permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage verifyAddress() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assertions.assertEquals(current[1], permanent[1]);
        return this;
    }

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;


    public TextBoxPage enterPersonalData(String name, String email, String address) {
        typeWithJS(userName, name, 0, 300);
        typeWithJS(userEmail, email, 0, 300);
        typeWithJS(currentAddress, address, 0, 300);
        type(permanentAddress, address);

        return this;
    }

    public TextBoxPage enterPersonalDataWithJS(String name, String email) {

        js.executeScript("document.getElementById('userName').value='" + name + "';");

        js.executeScript("document.getElementById('userEmail').value='" + email + "';");
        js.executeScript("document.getElementById('userEmail').style.border='5px solid red';");
        return this;
    }

    public TextBoxPage clickOnSubmitWithJS() {
        js.executeScript("document.querySelector('#submit').click();");
        js.executeScript("document.querySelector('#submit').style.backgroundColor='green';");
        return this;
    }

    public TextBoxPage getInnerText() {
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        System.out.println("===========================================");
        return this;
    }


    public TextBoxPage verifyUrl() {
        String url = js.executeScript("return document.URL").toString();
        System.out.println(url);
        System.out.println("===========================================");
        return this;
    }

    public TextBoxPage refreshWithJS() {
        js.executeScript("history.go(0);");
        return this;
    }

    public TextBoxPage navigateWithJS(String url) {
        js.executeScript("window.location='"+ url + "';");
        return this;

    }

    public TextBoxPage verifyFaveIconTitle() {
        Object title = js.executeScript("return document.title;").toString();
        System.out.println(title);
        System.out.println("===========================================");
        return this;
    }
}
