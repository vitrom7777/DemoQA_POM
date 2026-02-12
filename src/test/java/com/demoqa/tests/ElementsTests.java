package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.BrokenLinksImagesPage;
import com.demoqa.pages.elements.ButtonPage;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.pages.elements.UploadPage;
import com.demoqa.utils.MyArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ElementsTests extends TestBase {
    SidePanel sidePanel;
    ButtonPage button;
    TextBoxPage textBox;
    BrokenLinksImagesPage broken;
    UploadPage upload;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(driver);
        button = new ButtonPage(driver);
        textBox = new TextBoxPage(driver);
        broken = new BrokenLinksImagesPage(driver);
        upload = new UploadPage(driver);

        new HomePage(driver).getElements();
    }

    //2 raza click
    @Test
    public void doubleClickTest() {
        sidePanel.getButtons();
        button.doubleClick()
                .verifyDoubleClick("double click");

    }

    // pravi click
    @Test
    @Tag("smoky")
    public void rightClickTest() {
        sidePanel.getButtons();
        button.rightClick()
                .verifyRightClick("right click");
    }

    @Test
    public void copyPastTest() {
        sidePanel.getTextBox();
        textBox.copyPast(" address")
                .clickOnSubmitButton()
                .verifyAddress();
    }

    // parametrization  test
    //@Test
    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void textBoxWithParameterTest(String name, String email, String address) {
        sidePanel.getTextBox();
        textBox.enterPersonalData(name, email, address)
                .clickOnSubmitButton()
                .verifyAddress();

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Data.csv")
    public void textBoxWithCsvFileTest(String name, String email, String address) {
        sidePanel.getTextBox();
        textBox.enterPersonalData(name, email, address)
                .clickOnSubmitButton()
                .verifyAddress();

    }

    @Test
    public void javascriptExecutorTest() {
        sidePanel.getTextBox();
        textBox.enterPersonalDataWithJS("Jamal Musiala", "jamal@gm.com")
                // click
                .clickOnSubmitWithJS()
                .getInnerText()  // dostat' ves' text
                .verifyUrl()  //dostat URL
                .refreshWithJS() //refresh Page
                .navigateWithJS("https://ilcarro.web.app")
                .verifyFaveIconTitle()  //favicon
        ;
    }

    @Test

    public void getAllLinksTest() {
        sidePanel.getBrokenLinksImages();
        broken.getAllLinks();

    }

    @Test
    public void checkLinksImages() {
        sidePanel.getBrokenLinksImages();
        broken.checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
        sidePanel.getBrokenLinksImages();
        broken.checkBrokenImaged();
    }

    @Test
    public void performKeyEventTest() {
        sidePanel.getUpload();
        upload.performKeyEvent()
                .verifyFilePath("C:\\fakepath\\D1.txt")
        ;

    }
    @Test
    public void performMouseEventTest(){
        sidePanel.getUpload();
        upload.performMouseEvent()
                .verifyFilePath("C:\\fakepath\\D1.txt")
                ;
    }


}

//D1.txt