import com.PO.LoginPage;
import com.PO.MainPage;
import com.PO.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PersonalAccTest {
    MainPage mainPage =
            open("https://stellarburgers.nomoreparties.site/",
                    MainPage.class);

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Check success Transfer To Constructor from main page")
    public void successTransferToConstructor() throws InterruptedException { // тест на успешный переход в конструктор по заголовку "Конструктор" на главной
        mainPage.clickButtonPersonalAccountUnderList();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail("mashavikt@yandex.ru");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccountOnHeader();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickConstructorButton();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));
   }

    //ок, не происходит переход
    @Test
    @DisplayName("Check success Transfer To Main Page From Personal Acc")
    public void successTransferToMainPageFromPersonalAcc() throws InterruptedException { // тест на успешный переход на главную по логотипу в шапке Личного кабинета
        mainPage.clickButtonPersonalAccountUnderList();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail("mashavikt@yandex.ru");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccountOnHeader();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickLogoButton();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/"));

    }
}
