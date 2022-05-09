import com.PO.LoginPage;
import com.PO.MainPage;
import com.PO.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class ExitFromAccTest {
    MainPage mainPage =
            open("https://stellarburgers.nomoreparties.site/",
                    MainPage.class);

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Check success exit from acc")
    public void successExitFromAcc() throws InterruptedException { // тест на успешный переход в конструктор по заголовку "Конструктор" на главной
        mainPage.clickButtonPersonalAccountUnderList();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail("mashavikt@yandex.ru");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccountOnHeader();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickExitButton();
        boolean isLoginTitleDisplayed = loginPage.isLoginTitleDisplayed();
        assertTrue("Login Title not displayed by click Exit button from Personal Acc", isLoginTitleDisplayed);
    }
}
