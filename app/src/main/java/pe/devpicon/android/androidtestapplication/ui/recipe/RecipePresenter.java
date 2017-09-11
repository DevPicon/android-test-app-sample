package pe.devpicon.android.androidtestapplication.ui.recipe;

import pe.devpicon.android.androidtestapplication.data.local.Favorites;
import pe.devpicon.android.androidtestapplication.data.local.RecipeStore;
import pe.devpicon.android.androidtestapplication.data.model.Recipe;


public class RecipePresenter implements RecipeContract.Listener {
    private final RecipeStore store;
    private final RecipeContract.View view;
    private final Favorites favorites;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store, RecipeContract.View view, Favorites favorites) {
        this.store = store;
        this.view = view;
        this.favorites = favorites;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
        if (recipe == null) {
            view.showRecipeNotFoundError();
        } else {
            view.setTitle(recipe.title);
            view.setDescription(recipe.description);
            view.setFavorite(favorites.get(recipe.id));
        }
    }

    public void toggleFavorite() {
        if (recipe == null) {
            throw new IllegalStateException();
        }
        boolean result = favorites.toggle(recipe.id);
        view.setFavorite(result);
    }
}
