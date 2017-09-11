package pe.devpicon.android.androidtestapplication.injection;

import pe.devpicon.android.androidtestapplication.data.local.Favorites;
import pe.devpicon.android.androidtestapplication.data.local.InMemoryFavorites;

public class TestRecipeApplication extends RecipeApplication {
    private final Favorites favorites = new InMemoryFavorites();

    @Override
    public Favorites getFavorites() {
        return favorites;
    }
}
