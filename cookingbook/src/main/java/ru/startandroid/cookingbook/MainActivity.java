package ru.startandroid.cookingbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button add_recipe;
    Button view_recipe;
    Button search_recipe;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        add_recipe = (Button) findViewById(R.id.add_recipe);
        view_recipe = (Button) findViewById(R.id.view_recipe);
        search_recipe = (Button) findViewById(R.id.search_recipe);
        exit = (Button) findViewById(R.id.exit);

        add_recipe.setOnClickListener(this);
        view_recipe.setOnClickListener(this);
        search_recipe.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_recipe:
                Intent intent = new Intent(this,AddRecipeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.view_recipes:
                break;
            case R.id.search_recipe:
                break;
            case R.id.exit:
                break;
        }
    }
}