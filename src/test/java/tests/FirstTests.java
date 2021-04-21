package tests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstTests {

    @Test
    void simpleTest() {
        System.out.println(System.getProperties());

        assertThat(true).isEqualTo(true);
    }
}
