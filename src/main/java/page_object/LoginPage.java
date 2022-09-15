package page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String Path = "/login";

    private StellarHeader stellarHeader;

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//label[@name='Пароль']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//div[@class='input__icon input__icon-action']")
    private SelenideElement iconEye;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Зарегистрироваться']")
    private SelenideElement registerLink;

    @FindBy(how = How.XPATH, using = ".//p[text()='Восстановить пароль']")
    private SelenideElement restorePasswordLink;
}
