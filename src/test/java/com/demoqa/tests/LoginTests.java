package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.bookStore.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestBase {

    @BeforeEach
    public void precondition(){
        new HomePage(driver).getBookStore();
        new SidePanel(driver).getLogin();

    }
    @Test
    @Tag("smoky")
    public void loginPositiveTest(){
        new LoginPage(driver).enterUserData("vitrom7","Qwerty@123")
                                .clickOnLoginButton()
                .verifyUserName("vitrom7");
    }
    @Test
    @Tag("parameters")
    public void loginPositiveTestWithParameters(){
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        new LoginPage(driver).enterUserData(username,password)
                .clickOnLoginButton()
                .verifyUserName("vitrom7");
    }
}
