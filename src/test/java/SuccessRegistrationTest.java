import com.po.LoginPage;
import com.po.RegisterPage;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class SuccessRegistrationTest {

    RegisterPage registerPage =
            open("https://stellarburgers.nomoreparties.site/register",
                    RegisterPage.class);

    UserClient userClient;
    String accessToken;
    User user;


    @Before
    public void setUp() throws io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException {
        userClient = new UserClient();
        user = UserGenerator.getRandomEmailPasswordName();
    }

    @After
    public void tearDown()  {
     var createdUser =  userClient.login(user);
     accessToken =  createdUser.extract().path("accessToken");
     userClient.delete(accessToken);
     webdriver().driver().close();
    }

    @Test
    @DisplayName("Check success registration with password 7 symbols")
    public void successRegistration() throws JsonProcessingException { // тест на успешную регистрацию с паролем в 7 символов
        registerPage.registerForm(user.getName(), user.getEmail(), user.getPassword());
        LoginPage loginPage = page(LoginPage.class);

        boolean isLoginTitleDisplayed = loginPage.isLoginTitleDisplayed();

        assertTrue("Login Title not displayed after Registration", isLoginTitleDisplayed);


    }


    // отдельный класс
    @Test
    @DisplayName("Check unSuccess registration with password 5 symbols")
    public void UnSuccessRegistrationWithSmallPassword() { // тест на неуспешную регистрацию с паролем в 5 символов
        registerPage.registerForm(registerPage.getRandomName(), registerPage.getRandomEmail(),
                registerPage.getUnCorrectRandomPassword());
                registerPage.unCorrectPasswordTitle.shouldBe(visible);

                boolean unCorrectPasswordTitle = registerPage.isUnCorrectPasswordTitleDisplayed();
                assertTrue("UnCorrectPasswordTitle not displayed after enter UnCorrect password on Registration", unCorrectPasswordTitle);

    }

}
