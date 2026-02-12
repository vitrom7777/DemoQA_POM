package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.interactions.DragAndDropPage;
import org.junit.jupiter.api.*;

public class InteractionsTests extends TestBase {

    SidePanel sidePanel;
    DragAndDropPage dragAndDrop;


    @BeforeEach
    public void precondition(){
        sidePanel = new SidePanel(driver);
        dragAndDrop = new DragAndDropPage(driver);
        new HomePage(driver).getInteractions();

    }

    @Test
    @Tag("smoky")
    public void dragMyTest(){
        sidePanel.getDroppable();
        dragAndDrop.gradMe()
                .verifyDropped("Dropped!");
    }

    //
    @RepeatedTest(value = 3,name = "{displayName}{currentRepetition}/{totalRepetitions}")
    @DisplayName("Verify -> drag and drop element by coordinates/ Try to get error ")
    //@Test
    public void dragMeByTest(){
        sidePanel.getDroppable();
        dragAndDrop.dragMeBy()
                .verifyDropped("Dropped!");
    }
}
