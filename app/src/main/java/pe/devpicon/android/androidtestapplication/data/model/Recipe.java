package pe.devpicon.android.androidtestapplication.data.model;

import java.io.InputStream;

/**
 * Created by armando on 9/4/17.
 */

public class Recipe {
    public final String id;
    public final String title;
    public final String description;

    private Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Recipe readFromStream(InputStream stream){
        return null;
    }
}
