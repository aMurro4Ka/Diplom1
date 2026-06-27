import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.mockito.Mockito.*;
import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    // Тесты для метода setBuns
    @Test
    public void testSetBuns() {
        Bun bun = mock(Bun.class);
        burger.setBuns(bun);
        Assert.assertSame(bun, burger.bun);
    }

    // Тесты для метода addIngredient
    @Test
    public void testAddIngredientShouldIncreaseSize() {
        Ingredient ingredient = mock(Ingredient.class);
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testAddIngredientShouldContainAddedIngredient() {
        Ingredient ingredient = mock(Ingredient.class);
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }

    //  Тесты для метода removeIngredient
    @Test
    public void testRemoveIngredientShouldDecreaseSize() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);

        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientShouldRemoveCorrectElement() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);

        Assert.assertFalse(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testRemoveIngredientShouldKeepOtherElements() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);

        Assert.assertTrue(burger.ingredients.contains(ingredient2));
    }

    // Тесты для метода moveIngredient
    @Test
    public void testMoveIngredientShouldKeepSize() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0, 2);

        Assert.assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredientShouldMoveElementToCorrectPosition() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0, 2);

        Assert.assertSame(ingredient1, burger.ingredients.get(2));
    }

    @Test
    public void testMoveIngredientShouldShiftOtherElements() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0, 2);

        Assert.assertSame(ingredient2, burger.ingredients.get(0));
        Assert.assertSame(ingredient3, burger.ingredients.get(1));
    }
}