package pe.devpicon.android.androidtestapplication.data.model;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

/**
 * Created by armando on 9/4/17.
 */
public class RecipeTest {
    @Test
    public void water() {
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipe/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        assertNotNull(recipe);
    }
}