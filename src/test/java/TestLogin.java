import PageObject.LoginPage;
import PageObject.ProfilePage;
import api.AuthResponse;
import org.junit.*;
import test_methods.TestMethods;
import PageObject.ConstructorPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;

import static com.codeborne.selenide.Selenide.open;
import static test_methods.TestMethods.randomEmail;
import static test_methods.TestMethods.randomAlfaNum;

public class TestLogin {
    private TestMethods testMethods = new TestMethods();

    private String name;
    private String email;
    private String passwd;
    private String token;

    @Before
    public void prepareTest() {
        this.name = randomAlfaNum();
        this.passwd = randomAlfaNum();
        this.email = randomEmail();
        AuthResponse registerResponse = this.testMethods.registerUser(this.email, this.passwd, this.name);
        this.token = registerResponse.getAccessToken();
    }

    @After
    public void clearTest() {
        testMethods.deleteUser(this.token);
    }

    @Test
    @Description("Создать пользователя через API. Зайти на главную страницу https://stellarburgers.nomoreparties.site/. " +
            "Нажать на кнопку Войти в аккаунт. Ввести учётные данные пользователяи осуществить вход " +
            "на страницу конструктора уже залогиненного пользователя.")
    @DisplayName("Вход в аккаунт.")
    public void checkEnterFromConstructorByAccountButton() {
        ConstructorPage constructor = open(ConstructorPage.URL, ConstructorPage.class);
        LoginPage loginPage = constructor.clickLoginButton();
        loginPage.enterEmail(this.email);
        loginPage.enterPassword(this.passwd);
        ConstructorPage constructorLoggedIn = loginPage.clickLoginButton();
        constructorLoggedIn.checkConstructorLoggedIn();
    }

    @Test
    @Description("Создать пользователя через API. Зайти на главную страницу https://stellarburgers.nomoreparties.site/. " +
            "Нажать на ссылку Личный Кабинет в заголовке странице. Ввести учётные данные пользователяи осуществить вход " +
            "на страницу конструктора уже залогиненного пользователя.")
    @DisplayName("Вход через Личный Кабинет.")
    public void checkEnterFromConstructorByProfile() {
        ConstructorPage constructor = open(ConstructorPage.URL, ConstructorPage.class);
        LoginPage loginPage = constructor.stellarHeader.clickProfile();
        loginPage.enterEmail(this.email);
        loginPage.enterPassword(this.passwd);
        ConstructorPage constructorLoggedIn = loginPage.clickLoginButton();
        constructorLoggedIn.checkConstructorLoggedIn();
    }


    @Test
    @Description("Создать пользователя через API. Зайти на главную страницу регистрации https://stellarburgers.nomoreparties.site/. " +
            "Нажать на кнопку Войти в аккаунт. Ввести учётные данные пользователя. Зайти на страницу профиля пользователя")
    @DisplayName("Войти в аккаунт.")
    public void checkEnterFromRegister() {
        ConstructorPage constructor = open(ConstructorPage.URL, ConstructorPage.class);
        LoginPage loginPage = constructor.clickLoginButton();
        loginPage.enterEmail(this.email);
        loginPage.enterPassword(this.passwd);
        ConstructorPage constructorLoggedIn = loginPage.clickLoginButton();
        constructorLoggedIn.checkConstructorLoggedIn();
    }


    @Test
    @Description("Создать пользователя через API. Зайти на главную страницу восстановления пароля https://stellarburgers.nomoreparties.site/. " +
            "Нажать на кнопку Войти в аккаунт. Ввести учётные данные пользователя. Зайти на страницу профиля пользователя")
    @DisplayName("Войти в аккаунт.")
    public void checkEnterFromRestorePage() {
        ConstructorPage constructor = open(ConstructorPage.URL, ConstructorPage.class);
        LoginPage loginPage = constructor.clickLoginButton();
        loginPage.enterEmail(this.email);
        loginPage.enterPassword(this.passwd);
        ConstructorPage constructorLoggedIn = loginPage.clickLoginButton();
        constructorLoggedIn.checkConstructorLoggedIn();
    }

}
