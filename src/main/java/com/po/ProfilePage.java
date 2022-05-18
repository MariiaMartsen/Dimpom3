package com.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {
    @FindBy(how = How.CSS, using = "a[class*='Account_link_active__2opc9']")
    private SelenideElement profileTitle;

    @FindBy(how = How.CSS, using = "ul[class*='AppHeader_header__list__3oKJj'] > li:nth-of-type(1) > a")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/header/nav/div/a/svg")
    private SelenideElement logoButton;

    @FindBy(how = How.CSS, using = "button[class*='Account_button__14Yp3']")
    private SelenideElement exitButton;

    @Step("Check profileTitle is Displayed")
    public boolean isProfileTitleDisplayed() {
        return profileTitle.shouldBe(visible).isDisplayed();
    }

    @Step("Click constructorButton")
    public void clickConstructorButton() throws InterruptedException {
        constructorButton.click();

    }

    @Step("Click logoButton")
    public void clickLogoButton() throws InterruptedException {
        logoButton.click();

    }

    @Step("Click exitButton")
    public void clickExitButton() throws InterruptedException {
        exitButton.click();

    }
}
