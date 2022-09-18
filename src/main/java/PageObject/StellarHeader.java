package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class StellarHeader {
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Лента Заказов']")
    private SelenideElement ordersFeed;

    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement profile;

    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement stellarLogo;

    public ConstructorPage clickConstructor() {
        constructorButton.click();
        return page(ConstructorPage.class);
    }

    public FeedPage clickOrderFeed() {
        ordersFeed.click();
        return  page(FeedPage.class);
    }

    public ProfilePage clickProfile() {
        profile.click();
        return page(ProfilePage.class);
    }
}
