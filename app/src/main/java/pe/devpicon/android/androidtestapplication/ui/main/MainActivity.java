package pe.devpicon.android.androidtestapplication.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import pe.devpicon.android.androidtestapplication.R;
import pe.devpicon.android.androidtestapplication.data.local.RecipeStore;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recipes);
    RecipeStore store = new RecipeStore(this, "recipes");
    RecipeAdapter adapter = new RecipeAdapter(store);
    recyclerView.setAdapter(adapter);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
  }
}