package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.parameter;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTests {

    @Test
    void simpleTest() {
        parameter("tkn", System.getProperty("telegram.token"));
        assertThat(System.getProperty("threads")).isEqualTo("1");
        assertThat(System.getProperty("telegram.token")).isNotEqualTo("c05-fattaft-telegram-token");
    }
}
