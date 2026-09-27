package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BurgerTest {

    private static final float DELTA = 0.001f;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient sauce;

    @Mock
    private Ingredient filling;

    private Burger burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @Test
    void setBunsSetsBun() {
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    void addIngredientAddsIngredientToEnd() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        assertEquals(List.of(sauce, filling), burger.ingredients);
    }

    @Test
    void removeIngredientRemovesIngredientByIndex() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.removeIngredient(0);

        assertEquals(List.of(filling), burger.ingredients);
    }

    @Test
    void moveIngredientMovesIngredientToNewIndex() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.moveIngredient(0, 1);

        assertEquals(List.of(filling, sauce), burger.ingredients);
    }

    @ParameterizedTest
    @CsvSource({
            "100, 0, 0, 200",
            "100, 50, 70, 320",
            "0, 10.5, 20.5, 31",
            "200.5, 0.25, 0.25, 401.5"
    })
    void getPriceReturnsDoubleBunPricePlusIngredientsPrice(float bunPrice, float saucePrice,
                                                           float fillingPrice, float expectedPrice) {
        when(bun.getPrice()).thenReturn(bunPrice);
        when(sauce.getPrice()).thenReturn(saucePrice);
        when(filling.getPrice()).thenReturn(fillingPrice);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        assertEquals(expectedPrice, burger.getPrice(), DELTA);
    }

    @Test
    void getReceiptReturnsBunsIngredientsAndPrice() {
        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);
        when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        when(sauce.getName()).thenReturn("hot sauce");
        when(sauce.getPrice()).thenReturn(100f);
        when(filling.getType()).thenReturn(IngredientType.FILLING);
        when(filling.getName()).thenReturn("cutlet");
        when(filling.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String expectedReceipt = String.format("(==== black bun ====)%n")
                + String.format("= sauce hot sauce =%n")
                + String.format("= filling cutlet =%n")
                + String.format("(==== black bun ====)%n")
                + String.format("%nPrice: %f%n", 400f);

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
