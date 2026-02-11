package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class BrokenLinksImagesPage extends BasePage {
    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> alllinks;

    public BrokenLinksImagesPage getAllLinks() {
        // size
        System.out.println("Total links on page=" + alllinks.size());
        // list
        String url = "";
        Iterator<WebElement> iterator = alllinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
            System.out.println("=====================================");
        }
        return this;
    }

    public BrokenLinksImagesPage checkBrokenLinks() {
        for (int i = 0; i < alllinks.size(); i++) {
            WebElement element = alllinks.get(i);
            String url = element.getDomAttribute("href");
            verifyLinks(url);
        }
        softly.assertAll();
        return this;
    }


    @FindBy(css = "img")
    List<WebElement> images;

    public BrokenLinksImagesPage checkBrokenImaged() {
        try {
            System.out.println("Total images on the page = " + images.size());
            for (int i = 0; i < images.size(); i++) {
                WebElement image = images.get(i);
                String imageUrl = image.getAttribute("src");
                verifyLinks(imageUrl);
 boolean imageDisplayed = (Boolean) js.executeScript("return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);", image);
                if (imageDisplayed) {
                    //System.out.println("Display OK");
                    softly.assertThat(imageDisplayed);
                } else {
                    //System.out.println("Display - BROKEN");
                    //System.out.println("*******************************************");
               softly.fail("BROKEN images --> "+ imageUrl);
                }
            }
        } catch (Exception e) {
            //System.out.println("Error occurred");
            softly.fail("Error occurred");
            //throw new RuntimeException(e);
        }
        softly.assertAll();
        return this;
    }
}
