package test_methods;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import api.ApiClient;
import api.User;
import api.AuthResponse;
import api.Token;


public class TestMethods {

    private final ApiClient client = new ApiClient();

    public static String randomEmail() {
        return String.format("%s@%s.test", RandomStringUtils.randomAlphanumeric(4, 10), RandomStringUtils.randomAlphanumeric(4, 10));
    }

    public static String randomAlfaNum(int minLen, int maxLen) {
        return RandomStringUtils.randomAlphanumeric(minLen, maxLen);
    }

    public static String randomAlfaNum() {
        return RandomStringUtils.randomAlphanumeric(6, 20);
    }

    @Step("Регистрация пользовтеля через API")
    public AuthResponse registerUser(String email, String passwd, String name) {
        User user = new User(email, passwd, name);
        return client.createUser(user).as(AuthResponse.class);
    }

    @Step("Авторизация пользователя через API")
    public AuthResponse authUser(String email, String passwd) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwd);
        return client.loginUser(user).as(AuthResponse.class);
    }

    @Step("Получение информации о пользователе через API")
    public AuthResponse userInfo(String token) {
        return  client.getUserInfo(token).as(AuthResponse.class);
    }

    @Step("Удалить пользователя через API")
    public void deleteUser(String token) {
        client.deleteUser(token);
    }

    public void logoutUser(String refreshToken) {
        client.logoutUser(new Token(refreshToken));
    }
}
