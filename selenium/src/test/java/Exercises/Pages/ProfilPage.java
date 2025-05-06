package Exercises.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilPage {
    @FindBy(id = "gotoStore")
    private WebElement btn_gotoStore;


    @Step
    public void moveToStore()  {
        btn_gotoStore.click();
    }
}
