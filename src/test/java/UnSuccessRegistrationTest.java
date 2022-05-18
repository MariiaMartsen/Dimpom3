import com.po.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class UnSuccessRegistrationTest {
    RegisterPage registerPage =
            open("https://stellarburgers.nomoreparties.site/register",
                    RegisterPage.class);

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
