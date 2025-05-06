package Exercises.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement submit;

    @Step
    public void loginAction(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.submit.click();
    }
}
