package pe.devpicon.android.androidtestapplication.data.local;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import pe.devpicon.android.androidtestapplication.data.model.Recipe;

/**
 * Created by armando on 9/4/17.
 */

public class RecipeStore {

    public final List<Recipe> recipes = new ArrayList<>();

    public RecipeStore(Context context, String directory) {
        List<InputStream> streams = getAssetStreams(context.getAssets(), directory);
        for (InputStream stream: streams){
            Recipe recipe = Recipe.readFromStream(stream);
            if(recipe != null){
                recipes.add(recipe);
            }
        }
    }

    private static List<InputStream> getAssetStreams(AssetManager manager, String directory) {
        String[] filenames = getFilenames(manager, directory);
        List<InputStream> streams = new ArrayList<>();
        for (String filename : filenames) {
            File file = new File(directory, filename);
            try {
                InputStream stream = manager.open(file.getPath());
                if (stream != null) {
                    streams.add(stream);
                }
            } catch (IOException e) {
            }
        }
        return streams;
    }

    private static String[] getFilenames(AssetManager manager, String directory) {
        if (directory == null) {
            return new String[0];
        }

        try {
            return manager.list(directory);
        } catch (IOException e) {
            return new String[0];
        }
    }
}
