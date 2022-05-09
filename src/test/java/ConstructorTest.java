import com.PO.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    MainPage mainPage =
            open("https://stellarburgers.nomoreparties.site/",
                    MainPage.class);

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Check success transfer to filling part from TitleOnTab on main page")
    public void successTransferToFillingTest() throws InterruptedException {
       mainPage.clickFillingTitleOnTab();
       boolean isFillingTitleDisplayed = mainPage.isFillingTitleUnderTabDisplayed();
        assertTrue("Filling Title not displayed by click Filling Tab", isFillingTitleDisplayed);
    }

    @Test
    @DisplayName("Check success transfer to Sauce part from TitleOnTab on main page")
    public void successTransferToSauceTest() throws InterruptedException {
        mainPage.clickSauceTitleOnTab();
        boolean isSauceTitleUnderTabDisplayed = mainPage.isSauceTitleUnderTabDisplayed();
        assertTrue("Bun Title not displayed by click Filling Tab", isSauceTitleUnderTabDisplayed);
    }

    @Test
    @DisplayName("Check success transfer to bun part from TitleOnTab on main page")
    public void successTransferToBunTest() throws InterruptedException {
        mainPage.clickSauceTitleOnTab();
        mainPage.clickBunTitleOnTab();
        boolean isBunTitleUnderTabDisplayed = mainPage.isBunTitleUnderTabDisplayed();
        assertTrue("Bun Title not displayed by click Filling Tab", isBunTitleUnderTabDisplayed);
    }
}
