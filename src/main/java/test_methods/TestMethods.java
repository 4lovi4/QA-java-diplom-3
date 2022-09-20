package test_methods;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import api.ApiClient;
import api.User;
import api.AuthResponse;

public class TestMethods {
    public static String randomEmail() {
        return String.format("%s@%s.test", RandomStringUtils.randomAlphanumeric(4, 10), RandomStringUtils.randomAlphanumeric(4, 10));
    }

    public static String randomAlfaNum() {
        return RandomStringUtils.randomAlphanumeric(4, 16);
    }

    @Step("Регистрация пользовтеля через API")
    public void registerUser(String login, String email, String passwd) {
        ApiClient client = new ApiClient();
        User user = new User(email, passwd, login);
        AuthResponse register = client.createUser(user).as(AuthResponse.class);
    }

    @Step("Авторизация пользователя через API")
    public void authUser() {

    }

    @Step("Получение информации о пользователе через API")
    public void userInfo() {

    }

    @Step("Удалить пользователя через API")
    public void deleteUser() {

    }
}
