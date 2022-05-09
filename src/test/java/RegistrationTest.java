import com.PO.LoginPage;
import com.PO.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    RegisterPage registerPage =
            open("https://stellarburgers.nomoreparties.site/register",
                    RegisterPage.class);

    @After
    public void tearDown() {
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Check success registration with password 7 symbols")
    public void successRegistration() { // тест на успешную регистрацию с паролем в 7 символов
        registerPage.registerForm(registerPage.getRandomName(),
                registerPage.getRandomEmail(),
                registerPage.getCorrectRandomPassword());
                LoginPage loginPage = page(LoginPage.class);
                boolean isLoginTitleDisplayed = loginPage.isLoginTitleDisplayed();
                assertTrue("Login Title not displayed after Registration", isLoginTitleDisplayed);

    }

    @Test
    @DisplayName("Check unSuccess registration with password 5 symbols")
    public void UnSuccessRegistrationWithSmallPassword() { // тест на неуспешную регистрацию с паролем в 5 символов
        registerPage.registerForm(registerPage.getRandomName(),
                registerPage.getRandomEmail(),
                registerPage.getUnCorrectRandomPassword());
                registerPage.unCorrectPasswordTitle.shouldBe(visible);
                boolean unCorrectPasswordTitle = registerPage.isUnCorrectPasswordTitleDisplayed();
                assertTrue("UnCorrectPasswordTitle not displayed after enter UnCorrect password on Registration", unCorrectPasswordTitle);

    }

}
