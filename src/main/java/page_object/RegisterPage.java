package page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {

    public static final String Path = "/register";

    private StellarHeader stellarHeader;

    @FindBy(how = How.XPATH, using = ".//label[text()='Имя']")
    private SelenideElement nameInput;

    @FindBy(how = How.XPATH, using = ".//label[text()='Email']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//div[@class='input__icon input__icon-action']")
    private SelenideElement iconEye;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registerButton;

    public void enterLogin(String login) {
        nameInput.sendKeys(login);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickREgisterButton() {
        registerButton.click();
    }

    public void changePasswordVisibility() {
        iconEye.click();
    }
}
