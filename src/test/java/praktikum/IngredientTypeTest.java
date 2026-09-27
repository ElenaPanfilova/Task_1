package praktikum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTypeTest {

    @Test
    void valuesContainsSauceAndFilling() {
        IngredientType[] expectedTypes = {IngredientType.SAUCE, IngredientType.FILLING};

        assertArrayEquals(expectedTypes, IngredientType.values());
    }

    @ParameterizedTest
    @ValueSource(strings = {"SAUCE", "FILLING"})
    void valueOfReturnsTypeWithSameName(String typeName) {
        assertEquals(typeName, IngredientType.valueOf(typeName).name());
    }
}
