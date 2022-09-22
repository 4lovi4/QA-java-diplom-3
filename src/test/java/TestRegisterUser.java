import PageObject.LoginPage;
import api.AuthResponse;
import test_methods.TestMethods;
import org.junit.Test;
import PageObject.ConstructorPage;
import PageObject.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;

import com.codeborne.selenide.Condition;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static test_methods.TestMethods.randomEmail;
import static test_methods.TestMethods.randomAlfaNum;

public class TestRegisterUser {

    @Test
    @DisplayName("Регистрация пользователя через форму /register")
    @Description("Зарегистрировать пользователя через UI на странице/, " +
            "проверить что открылась страницы /login, " +
            "проверить, что можно залогиниться")
    public void checkUserRegister() throws InterruptedException {
        RegisterPage registerPage = open(ConstructorPage.URL + RegisterPage.Path, RegisterPage.class);
        String name = randomAlfaNum();
        String passwd = randomAlfaNum();
        String email = randomEmail();
        registerPage.enterEmail(randomEmail());
        registerPage.enterLogin(randomAlfaNum());
        registerPage.enterPassword(randomAlfaNum());
        registerPage.changePasswordVisibility();
        registerPage.getPasswordInputOpen().shouldBe(Condition.appear);
        LoginPage loginPage = registerPage.clickRegisterButton();
        loginPage.entranceTitle.shouldBe(Condition.visible);
        Assert.assertEquals(ConstructorPage.URL + LoginPage.Path, url());
        TestMethods testMethods = new TestMethods();
        AuthResponse authResponse = testMethods.authUser(email, passwd);
        AuthResponse userInfo = testMethods.userInfo(authResponse.getAccessToken());
        Assert.assertTrue(userInfo.getSuccess());
        Assert.assertEquals(name, userInfo.getUser().getName());
        Assert.assertEquals(email, userInfo.getUser().getEmail());
        testMethods.deleteUser(authResponse.getAccessToken());
    }
}

