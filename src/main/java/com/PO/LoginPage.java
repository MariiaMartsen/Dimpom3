package com.PO;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerLink;

    @FindBy(how = How.CSS, using = "div[class*='Auth_login__3hAey'] > h2")
    private SelenideElement loginTitle;

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;

    @FindBy(how = How.CSS, using = "button[class*='button_button__33qZ0']")
    private SelenideElement loginButton;

    @FindBy(how = How.CSS, using = "a[href*='forgot-password']")
    private SelenideElement recoverPasswordButton;

    @Step("Click RegisterLink on Registration Page")
    public void clickRegisterLink() {
        registerLink.click();
    }

    @Step("Click LoginButton on Registration Page")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Click recoverPasswordButton on Registration Page")
    public void clickRecoverPasswordButton() {
        recoverPasswordButton.click();
    }

    @Step("Set Email on Login Form")
    public void setEmail(String email) {
        emailField.click();
        emailField.setValue(email);
    }

    @Step("Set Password on Login Form")
    public void setPassword(String password) {
        passwordField.click();
        passwordField.setValue(password);
    }

    @Step("Check Password on Login Form")
    public boolean isLoginTitleDisplayed() {
        return loginTitle.shouldBe(visible).isDisplayed();
    }

//    @Step("Login with existing Email and Password")
//    public void fillLoginForm() {
//        emailField.click();
//        emailField.setValue("mashavikt@yandex.ru");
//        passwordField.click();
//        passwordField.setValue("123456");
//    }

}
