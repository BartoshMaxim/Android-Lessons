package ru.startandroid.cookingbook;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ShowRecipleActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listRecipesShowRecipeActivity;
    List<Recipe> allRecipes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes);

        listRecipesShowRecipeActivity = (ListView) findViewById(R.id.listRecipesShowRecipeActivity);

        DatabaseRecipe dB = new DatabaseRecipe(this);

        allRecipes = dB.getAllContacts();
        String[] allNames = new String[dB.countRecipes];

        int i = 0;
        for (Recipe recipe : allRecipes) {
            allNames[i] = recipe.get_name();
            i++;
        }

// используем адаптер данных
        ArrayAdapter<Recipe> adapter = new ArrayAdapter<Recipe>(this,
                android.R.layout.simple_list_item_1, allRecipes);

        listRecipesShowRecipeActivity.setAdapter(adapter);

    }

    @Override
    public void onClick(View view) {

    }
}
