package pe.devpicon.android.androidtestapplication.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import pe.devpicon.android.androidtestapplication.data.model.Recipe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by armando on 9/4/17.
 */
public class RecipeStoreTest {
    @Test
    public void nullDirectory() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(0, store.recipes.size());
    }
    @Test
    public void count() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(4, store.recipes.size());
    }
    @Test
    public void getChocolatePudding() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        Recipe recipe = store.getRecipe("chocolate_pudding");
        assertNotNull(recipe);
        assertEquals("chocolate_pudding", recipe.id);
        assertEquals("Chocolate Pudding", recipe.title);
    }
}