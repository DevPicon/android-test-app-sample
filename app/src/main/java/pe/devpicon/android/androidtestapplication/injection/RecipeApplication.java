package pe.devpicon.android.androidtestapplication.injection;

import android.app.Application;

import pe.devpicon.android.androidtestapplication.data.local.Favorites;
import pe.devpicon.android.androidtestapplication.data.local.SharedPreferencesFavorites;

public class RecipeApplication extends Application {
    private Favorites favorites = null;

    public Favorites getFavorites() {
        if (favorites == null) {
            favorites = new SharedPreferencesFavorites(this);
        }
        return favorites;
    }
}
