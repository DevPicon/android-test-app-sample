package pe.devpicon.android.androidtestapplication.test;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import pe.devpicon.android.androidtestapplication.R;
import pe.devpicon.android.androidtestapplication.data.local.InMemoryFavorites;
import pe.devpicon.android.androidtestapplication.injection.TestRecipeApplication;
import pe.devpicon.android.androidtestapplication.ui.recipe.RecipeActivity;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {
    private final InMemoryFavorites favorites;

    public RecipeRobot() {
        TestRecipeApplication app = (TestRecipeApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();
        favorites = (InMemoryFavorites) app.getFavorites();
        favorites.clear();
    }

    public RecipeRobot launch(ActivityTestRule rule) {
        rule.launchActivity(null);
        return this;
    }

    public RecipeRobot launch(ActivityTestRule rule, String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        rule.launchActivity(intent);
        return this;
    }

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(R.id.description, stringId);
    }

    public RecipeRobot setFavorite(String id) {
        favorites.put(id, true);
        return this;
    }

    public RecipeRobot isFavorite() {
        return checkIsSelected(R.id.title);
    }
}
