import PageObject.LoginPage;
import com.codeborne.selenide.Condition;
import org.junit.Test;
import PageObject.ConstructorPage;
import PageObject.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static test_methods.TestMethods.randomEmail;
import static test_methods.TestMethods.randomAlfaNum;

public class TestRegisterUser {



    @Test
    public void checkUserRegister() {
        RegisterPage registerPage = open(ConstructorPage.URL + RegisterPage.Path, RegisterPage.class);
        String login = randomAlfaNum();
        String passwd = randomAlfaNum();
        String email = randomEmail();
        registerPage.enterEmail(randomEmail());
        registerPage.enterLogin(randomAlfaNum());
        registerPage.enterPassword(randomAlfaNum());
        registerPage.changePasswordVisibility();
        registerPage.getPasswordInputOpen().shouldBe(Condition.appear);
        LoginPage loginPage = registerPage.clickRegisterButton();
        sleep(3000);
    }
}

