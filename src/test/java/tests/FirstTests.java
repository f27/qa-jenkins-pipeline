package tests;

import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.parameter;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstTests {

    @Test
    void simpleTest() {
        parameter("tkn", System.getProperty("telegram.token"));

        assertThat(System.getProperty("threads")).isEqualTo("2");
    }

    @Test
    void anotherSimpleTest() {

        assertThat(true).isEqualTo(true);
        assertThat(false).isNotEqualTo(true);
    }
}
