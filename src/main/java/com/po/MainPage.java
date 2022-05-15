package com.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    public SelenideElement personalAccountButtonUnderList;

    @FindBy(how = How.CSS, using = "a[href*='account']")
    public SelenideElement personalAccountButtonOnHeader;

    @FindBy(how = How.CSS, using = "h1[class*='text_type_main-large']")
    public SelenideElement constructBurgerTitle;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]")
    public SelenideElement bunTitleOnTab;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]")
    public SelenideElement sauceTitleOnTab;

    @FindBy(how = How.CSS, using = "section[class*='BurgerIngredients_ingredients__1N8v2'] > div:nth-of-type(1) > div:nth-of-type(3)")
    public SelenideElement fillingTitleOnTab;

    @FindBy(how = How.CSS, using = "div[class*='BurgerIngredients_ingredients__menuContainer__Xu3Mo'] > h2:nth-of-type(1)")
    public SelenideElement bunTitleUnderTab;

    @FindBy(how = How.XPATH, using = ".//div/ul[2]")
    public SelenideElement sauceTitleUnderTab;

    @FindBy(how = How.XPATH, using = ".//div/ul[3]")
    public SelenideElement fillingTitleUnderTab;


    @Step("Click ButtonPersonalAccountUnderList")
    public void clickButtonPersonalAccountUnderList() throws InterruptedException {
        personalAccountButtonUnderList.click();

    }

    @Step("Click ButtonPersonalAccountOnHeader")
    public void clickButtonPersonalAccountOnHeader() throws InterruptedException {
        personalAccountButtonOnHeader.click();

    }

    @Step("Click bunTitleOnTab")
    public void clickBunTitleOnTab() throws InterruptedException {
        bunTitleOnTab.click();

    }

    @Step("Click sauceTitleOnTab")
    public void clickSauceTitleOnTab() throws InterruptedException {
        sauceTitleOnTab.click();

    }

    @Step("Click fillingTitleOnTab")
    public void clickFillingTitleOnTab() throws InterruptedException {
        fillingTitleOnTab.click();

    }

    @Step("Check ConstructBurgerTitleDisplayed")
    public boolean isConstructBurgerTitleDisplayed() {
        return constructBurgerTitle.shouldBe(visible).isDisplayed();
    }

    @Step("Check FillingTitleUnderTabDisplayed")
    public boolean isFillingTitleUnderTabDisplayed() {
        return fillingTitleUnderTab.shouldBe(visible).isDisplayed();
    }

    @Step("Check SauceTitleUnderTabDisplayed")
    public boolean isSauceTitleUnderTabDisplayed() {
        return sauceTitleUnderTab.shouldBe(visible).isDisplayed();
    }

    @Step("Check BunTitleUnderTabDisplayed")
    public boolean isBunTitleUnderTabDisplayed() {
        return bunTitleUnderTab.shouldBe(visible).isDisplayed();
    }

}
