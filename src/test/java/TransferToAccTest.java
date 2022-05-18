import com.fasterxml.jackson.core.JsonProcessingException;
import com.po.LoginPage;
import com.po.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TransferToAccTest {
    MainPage mainPage =
            open(BurgerRestClient.BASE_URL,
                    MainPage.class);

    UserClient userClient;
    User user;
    String accessToken;
    String userEmail;
    String userPassword;

    @Before
    public void setUp() throws JsonProcessingException, io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException {
        userClient = new UserClient();
        user = UserGenerator.getRandomEmailPasswordName();
        userEmail = user.getEmail();
        userPassword = user.getPassword();
        var createdUser =  userClient.create(user);
        accessToken =  createdUser.extract().path("accessToken");
    }

    @After
    public void tearDown() {
        userClient.delete(accessToken);
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Check success transfer to Personal Acc from maim page")
    public void successTransferToPersonalAcc() throws InterruptedException { // тест на успешный переход в личный кабинет по кнопке "Личный кабинет" на главной
        mainPage.clickButtonPersonalAccountUnderList();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail(userEmail);
        loginPage.setPassword(userPassword);
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccountOnHeader();
        webdriver().shouldHave(url("https://stellarburgers.nomoreparties.site/account/profile"));
    }
}
