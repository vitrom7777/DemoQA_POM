package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class SelectPage extends BasePage {
    public SelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectPage oldStyleSelect(String color) {
       new  Select(oldSelectMenu).selectByVisibleText(color);
        return this;
    }

    public SelectPage verifyColor() {
        Assertions.assertTrue(shouldHaveText(oldSelectMenu,
                new Select(oldSelectMenu).getFirstSelectedOption().getText(),5));
        return this;
    }


    @FindBy(id = "react-select-4-input")
    WebElement selectInput;
    @FindBy(css = "html")
    WebElement space;
    public SelectPage multiSelect(String[] colors) {
        for (String text: colors) {
            selectInput.sendKeys(text);
            selectInput.sendKeys(Keys.ENTER);
        }
        click(space);  //ubrat pestoj spisok click space
        return this;
    }

//pisat manual t.k. net
    public SelectPage verifyMultiSelect(String[] colors) {
        for (String text:colors) {
            WebElement element = driver.findElement(By.xpath("//*[.='" + text + "']"));
            softly.assertThat(shouldHaveText(element,text,2));
            //tak kak eto cicl -> softly
        }
        softly.assertAll();
        return this;
    }

// selected po color
    public SelectPage verifySelectedCar(String car,String color) {
        WebElement selectCar = driver.findElement(By.cssSelector("[value='" + car + "']"));
click(selectCar);
        //System.out.println(selectCar.getCssValue("background-color"));

        Assertions.assertTrue(isContainsCssValue(color, selectCar,"background-color"));
    return this;
    }

    public boolean isContainsCssValue(String color, WebElement selectCar,String value) {
        return selectCar.getCssValue(value).contains(color);
    }
}
