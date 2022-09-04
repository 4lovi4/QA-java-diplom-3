package page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    @FindBy(how = How.XPATH, using = ".//a[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//a[@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement ordersFeed;

}
