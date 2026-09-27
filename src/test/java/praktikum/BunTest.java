package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BunTest {

    @ParameterizedTest
    @CsvSource({
            "black bun, 100",
            "white bun, 200",
            "'', 0",
            "red bun, 0.01"
    })
    void getNameReturnsNameFromConstructor(String name, float price) {
        Bun bun = new Bun(name, price);

        assertEquals(name, bun.getName());
    }

    @ParameterizedTest
    @CsvSource({
            "black bun, 100",
            "white bun, 200",
            "'', 0",
            "red bun, 0.01"
    })
    void getPriceReturnsPriceFromConstructor(String name, float price) {
        Bun bun = new Bun(name, price);

        assertEquals(price, bun.getPrice());
    }
}
