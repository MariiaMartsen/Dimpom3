import com.fasterxml.jackson.core.JsonProcessingException;
import com.po.LoginPage;
import com.po.MainPage;
import com.po.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;


public class ExitFromAccTest {
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
    @DisplayName("Check success exit from acc")
    public void successExitFromAcc() throws InterruptedException { // тест на успешный переход в конструктор по заголовку "Конструктор" на главной
        mainPage.clickButtonPersonalAccountUnderList();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmail(userEmail);
        loginPage.setPassword(userPassword);
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccountOnHeader();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickExitButton();
        boolean isLoginTitleDisplayed = loginPage.isLoginTitleDisplayed();
        assertTrue("Login Title not displayed by click Exit button from Personal Acc", isLoginTitleDisplayed);
    }
}
