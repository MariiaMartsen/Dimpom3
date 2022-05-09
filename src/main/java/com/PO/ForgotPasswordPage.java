package com.PO;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    @FindBy(how = How.CSS, using = "a[class*='Auth_link__1fOlj']")
    private SelenideElement personalAccOnForgotPasswordPage;

    @Step("Click personalAccOnForgotPasswordPage on ForgotPasswordPage")
    public void clickPersonalAccOnForgotPasswordPage() {
        personalAccOnForgotPasswordPage.click();
    }
}
