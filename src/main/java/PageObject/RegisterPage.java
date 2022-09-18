package PageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RegisterPage {

    public static final String Path = "/register";

    private StellarHeader stellarHeader;

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private List<SelenideElement> nameEmailInputs;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//input[@type='text' and @name='Пароль']")
    private SelenideElement passwordInputOpen;

    @FindBy(how = How.XPATH, using = ".//div[@class='input__icon input__icon-action']")
    private SelenideElement iconEye;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registerButton;

    public void enterLogin(String login) {
        nameEmailInputs.get(0).sendKeys(login);
    }

    public void enterEmail(String email) {
        nameEmailInputs.get(1).sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public LoginPage clickRegisterButton() {
        registerButton.click();
        return page(LoginPage.class);
    }

    public void changePasswordVisibility() {
        iconEye.click();
    }

    public SelenideElement getPasswordInputOpen() {
        return this.passwordInputOpen;
    }
}
