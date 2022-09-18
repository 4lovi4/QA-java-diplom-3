package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RestorePasswordPage {

    public static final String Path = "/forgot-password";

    private StellarHeader stellarHeader;

    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement restoreButton;

    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLink;

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickLoginButton() {
        restoreButton.click();
    }

    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }

}
