package page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    public static final String Path = "register";

    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Лента Заказов']")
    private SelenideElement ordersFeed;

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement profile;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement stellarLogo;

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
}
