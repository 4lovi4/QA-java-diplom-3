import org.junit.Test;
import page_object.ConstructorPage;
import page_object.RegisterPage;

import static com.codeborne.selenide.Selenide.open;

public class TestRegisterUser {

    @Test
    public void checkUserRegister() {
        RegisterPage registerPage = open(ConstructorPage.URL + RegisterPage.Path, RegisterPage.class);
    }
}

