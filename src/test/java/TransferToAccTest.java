import com.PO.LoginPage;
import com.PO.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TransferToAccTest {
    MainPage mainPage =
            open("https://stellarburgers.nomoreparties.site/",
                    MainPage.class);

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Check success transfer to Personal Acc from maim page")
    public void successTransferToPersonalAcc() throws InterruptedException { // тест на успешный переход в личный кабинет по кнопке "Личный кабинет" на главной
        mainPage.clickButtonPersonalAccountUnderList();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail("mashavikt@yandex.ru");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccountOnHeader();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/account/profile"));
    }
}
