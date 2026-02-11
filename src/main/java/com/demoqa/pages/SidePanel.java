package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.WindowsPage;
import com.demoqa.pages.alertsFrameWindows.iframesPage;
import com.demoqa.pages.bookStore.LoginPage;
import com.demoqa.pages.elements.BrokenLinksImagesPage;
import com.demoqa.pages.elements.ButtonPage;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.pages.elements.UploadPage;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.pages.interactions.DragAndDropPage;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.pages.widgets.SelectPage;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.pages.widgets.ToolTipsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;


    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;


    public LoginPage getLogin() {
        clickWithJS(login, 0, 600);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage getAlerts() {
        clickWithJS(alerts, 0, 300);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public WindowsPage getBrowserWindows() {
        click(browserWindows);
        return new WindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public iframesPage getFrames() {
        clickWithJS(frames, 0, 200);
        return new iframesPage(driver);
    }


    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public iframesPage getNestedFrames() {
        clickWithJS(nestedFrames, 0, 400);
        return new iframesPage(driver);
    }


    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectPage getSelectMenu() {
        clickWithJS(selectMenu, 0, 700);
        return new SelectPage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage getMenu() {
        clickWithJS(menu, 0, 700);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage getSlider() {
        clickWithJS(slider, 0, 400);
        return new SliderPage(driver);
    }


    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public ToolTipsPage getToolTips() {
        clickWithJS(toolTips, 0, 400);
        return new ToolTipsPage(driver);
    }

    public DragAndDropPage getDroppable() {
        clickWithJS(droppable, 0, 600);
        return new DragAndDropPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonPage getButtons() {
        clickWithJS(buttons, 0, 400);
        return new ButtonPage(driver);
    }


    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public TextBoxPage getTextBox() {
        click(textBox);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage getPracticeForms() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }


    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;
    public BrokenLinksImagesPage getBrokenLinksImages() {
clickWithJS(brokenLinksImages,0,500);
        return new BrokenLinksImagesPage(driver);
    }


    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement uploadDownload;

    public UploadPage getUpload() {
        clickWithJS(uploadDownload,0,600);

        return new UploadPage(driver);
    }
}
