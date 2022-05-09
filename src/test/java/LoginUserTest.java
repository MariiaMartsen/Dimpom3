import com.PO.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class LoginUserTest {

    MainPage mainPage =
            open("https://stellarburgers.nomoreparties.site/",
                    MainPage.class);

    @After
    public void tearDown() {
        webdriver().driver().close();
    }


    @Test
    @DisplayName("Check success LoginByLoginIntoAccButton on main page")
    public void successLoginByLoginIntoAccButton() throws InterruptedException { // тест на успешный логин по кнопке "Войти в аккаунт" на главной
    mainPage.clickButtonPersonalAccountUnderList();
    LoginPage loginPage = page(LoginPage.class);
    loginPage.setEmail("mashavikt@yandex.ru");
    loginPage.setPassword("123456");
    loginPage.clickLoginButton();
    boolean isConstructBurgerTitleDisplayed = mainPage.isConstructBurgerTitleDisplayed();
    assertTrue("ConstructBurger Title not displayed after Login to Personal Acc by ButtonPersonalAccountUnderList", isConstructBurgerTitleDisplayed);

    }

    @Test
    @DisplayName("Check success LoginByButtonOnHeader on main page")
    public void successLoginByButtonOnHeader() throws InterruptedException { // тест на успешный логин по кнопке "Личный кабинет" на главной
        mainPage.clickButtonPersonalAccountOnHeader();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail("mashavikt@yandex.ru");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
        boolean isConstructBurgerTitleDisplayed = mainPage.isConstructBurgerTitleDisplayed();
        assertTrue("ConstructBurger Title not displayed after Login to Personal Acc by ButtonPersonalAccountOnHeader on Main page", isConstructBurgerTitleDisplayed);


    }


    @Test
    @DisplayName("Check success Login On Registration Page")
    public void successLoginOnRegistrationPage() throws InterruptedException { // тест на успешный логин по кнопке "Войти" на странице регистрации
        mainPage.clickButtonPersonalAccountOnHeader();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterLink();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.clickPersonalAccOnRegistrationPage();
        loginPage.setEmail("mashavikt@yandex.ru");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
        boolean isConstructBurgerTitleDisplayed = mainPage.isConstructBurgerTitleDisplayed();
        assertTrue("ConstructBurger Title not displayed after Login to Personal Acc by ButtonPersonalAccountOnHeader on registration page", isConstructBurgerTitleDisplayed);


    }


    @Test
    @DisplayName("Check success Login On Recover Password age")
    public void successLoginOnRecoverPasswordPage() throws InterruptedException { // тест на успешный логин по кнопке "Войти" на странице восстановления пароля
        mainPage.clickButtonPersonalAccountOnHeader();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRecoverPasswordButton();
        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.clickPersonalAccOnForgotPasswordPage();
        loginPage.setEmail("mashavikt@yandex.ru");
        loginPage.setPassword("123456");
        loginPage.clickLoginButton();
        boolean isConstructBurgerTitleDisplayed = mainPage.isConstructBurgerTitleDisplayed();
        assertTrue("ConstructBurger Title not displayed after Login to Personal Acc by ButtonPersonalAccountOnHeader on recover password page", isConstructBurgerTitleDisplayed);


    }


}
