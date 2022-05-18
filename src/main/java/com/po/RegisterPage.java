package com.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;


public class RegisterPage {
    @FindBy(how = How.XPATH, using = "//div/*[contains(text(), 'Имя')]/following-sibling::input")
    public SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private SelenideElement emailField;

    @FindBy(how = How.NAME, name = "Пароль")
    private SelenideElement passwordField;


    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/h2")
    public SelenideElement registerTitle;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/div/p/a")
    public SelenideElement personalAccOnRegistrationPage;

    @FindBy(how = How.CSS, using = "p[class*='input__error']")
    public SelenideElement unCorrectPasswordTitle;

    public void clickPersonalAccOnRegistrationPage() throws InterruptedException {
        personalAccOnRegistrationPage.click();

    }

    public void clickNameField() throws InterruptedException {
        nameField.click();

    }

    @Step("Click Registration button")
    public void setRegistration() {
        registerButton.click();
    }

    @Step("Set Name on Registration Form")
    public void setName(String name) {
        nameField.click();
        nameField.setValue(name);
    }

    @Step("Set Email on Registration Form")
    public void setEmail(String email) {
        emailField.click();
        emailField.setValue(email);
    }

    @Step("Set password on Registration Form")
    public void setPassword(String password) {
        passwordField.click();
        passwordField.setValue(password);
    }


    @Step("Registration new user")
    public void registerForm(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setRegistration();
    }

    @Step("Get random name")
    public String getRandomName() {
        return RandomStringUtils.randomAlphabetic(9);
    }

    @Step("Get random email")
    public String getRandomEmail() {
        return RandomStringUtils.randomAlphabetic(9) + "@yandex.ru";
    }

    @Step("Get random password with 7 elements")
    public String getCorrectRandomPassword() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    @Step("Get random password with 5 elements")
    public String getUnCorrectRandomPassword() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    @Step("Check unCorrectPasswordTitle is Displayed")
    public boolean isUnCorrectPasswordTitleDisplayed() {
        return unCorrectPasswordTitle.shouldBe(visible).isDisplayed();
    }
}
