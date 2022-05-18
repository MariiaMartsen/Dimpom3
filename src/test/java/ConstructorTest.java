import com.po.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    MainPage mainPage =
            open(BurgerRestClient.BASE_URL,
                    MainPage.class);

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Check success transfer to filling part from TitleOnTab on main page")
    public void successTransferToFillingTest() throws InterruptedException {
       mainPage.clickFillingTitleOnTab();
       boolean isChosenTitleSauceDisplayed = mainPage.isChosenClassEnabled();
        mainPage.sectionChosenType.shouldHave(exactText("Начинки"));
        assertTrue("Filling Title not displayed by click Filling Tab", isChosenTitleSauceDisplayed);
    }

    @Test
    @DisplayName("Check success transfer to Sauce part from TitleOnTab on main page")
    public void successTransferToSauceTest() throws InterruptedException {
        mainPage.clickSauceTitleOnTab();
        boolean isChosenTitleSauceDisplayed = mainPage.isChosenClassEnabled();
        mainPage.sectionChosenType.shouldHave(exactText("Соусы"));
        assertTrue("Bun Title not displayed by click Filling Tab", isChosenTitleSauceDisplayed);

    }

    @Test
    @DisplayName("Check success transfer to bun part from TitleOnTab on main page")
    public void successTransferToBunTest() throws InterruptedException {
        mainPage.clickSauceTitleOnTab();
        mainPage.clickBunTitleOnTab();
        boolean isChosenTitleSauceDisplayed = mainPage.isChosenClassEnabled();
        mainPage.sectionChosenType.shouldHave(exactText("Булки"));
        assertTrue("Bun Title not displayed by click Filling Tab", isChosenTitleSauceDisplayed);

    }
}
