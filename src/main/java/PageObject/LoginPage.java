package PageObject;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String PATH = "/login";

    public StellarHeader stellarHeader = page(StellarHeader.class);

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//div[@class='input__icon input__icon-action']")
    private SelenideElement iconEye;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerLink;

    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement restorePasswordLink;

    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    public SelenideElement entranceTitle;

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public ConstructorPage clickLoginButton() {
        loginButton.click();
        return page(ConstructorPage.class);
    }

    public void changePasswordVisibility() {
        iconEye.click();
    }
}
