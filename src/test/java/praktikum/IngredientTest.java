package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    @ParameterizedTest
    @CsvSource({
            "SAUCE, hot sauce, 100",
            "FILLING, cutlet, 0.5"
    })
    void getTypeReturnsTypeFromConstructor(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
    }

    @ParameterizedTest
    @CsvSource({
            "SAUCE, hot sauce, 100",
            "FILLING, cutlet, 0.5"
    })
    void getNameReturnsNameFromConstructor(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(name, ingredient.getName());
    }

    @ParameterizedTest
    @CsvSource({
            "SAUCE, hot sauce, 100",
            "FILLING, cutlet, 0.5"
    })
    void getPriceReturnsPriceFromConstructor(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(price, ingredient.getPrice());
    }
}
