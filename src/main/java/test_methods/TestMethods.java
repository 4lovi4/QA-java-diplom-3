package test_methods;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class TestMethods {
    public static String randomEmail() {
        return String.format("%s@%s.test", RandomStringUtils.randomAlphanumeric(4, 10), RandomStringUtils.randomAlphanumeric(4, 10));
    }

    public static String randomAlfaNum() {
        return RandomStringUtils.randomAlphanumeric(4, 16);
    }
}
