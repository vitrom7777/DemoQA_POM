package com.demoqa.pages.bookStore;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="userName")
    WebElement  userNameInput;

    @FindBy(id ="password")
    WebElement  passwordInput;

    public LoginPage enterUserData(String userName, String password) {
       type(userNameInput,userName);
      // typeWithJS(userNameInput,userName,0,300); //if test no
       type(passwordInput,password);
        return this;
    }


    @FindBy(id ="login")
    WebElement  loginButton;
    public LoginPage clickOnLoginButton () {
        click(loginButton);
        return this;
    }
@FindBy(id = "userName-value")
WebElement userNameValue;


    public LoginPage verifyUserName(String name) {
        Assertions.assertTrue(isContainsText(name, userNameValue));
        return this;
    }
}
