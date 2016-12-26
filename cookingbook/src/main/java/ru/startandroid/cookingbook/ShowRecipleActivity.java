package ru.startandroid.cookingbook;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class ShowRecipleActivity extends AppCompatActivity implements View.OnClickListener {

    List<Recipe> allRecipes;

    ScrollView scrollViewShowRecipleActivity;
    LinearLayout linearLayoutLayoutShowRecipleActivity;
    Button goBackShowRecipleActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes);

        scrollViewShowRecipleActivity = (ScrollView) findViewById(R.id.scrollViewShowRecipleActivity);
        linearLayoutLayoutShowRecipleActivity = (LinearLayout) findViewById(R.id.linearLayoutLayoutShowRecipleActivity);
        goBackShowRecipleActivity = (Button) findViewById(R.id.goBackShowRecipleActivity);

        goBackShowRecipleActivity.setOnClickListener(this);

        DatabaseRecipe dB = new DatabaseRecipe(this);

        allRecipes = dB.getAllContacts();
        String[] allNames = new String[dB.countRecipes];

        for (Recipe recipe : allRecipes) {
            formRecipe(linearLayoutLayoutShowRecipleActivity, recipe);

        }

    }


    public void formRecipe(LinearLayout view, final Recipe recipe) {
        TextView nameView = new TextView(this);
        TextView descriptionView = new TextView(this);
        ImageView imageView = new ImageView(this);
        View viewView = new View(this);
        ImageView editImageView = new ImageView(this);
        ImageView deleteImageView = new ImageView(this);
        LinearLayout horizLL = new LinearLayout(this);

        horizLL.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams paramsView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,2);
        LinearLayout.LayoutParams imagesView = new LinearLayout.LayoutParams(50,50);

        imagesView.setMargins(0, 0, 30, 0);

        params.setMargins(20, 30, 0, 0);
        paramsView.setMargins(20, 30, 0, 30);



        viewView.setBackgroundColor(Color.BLACK) ;

        nameView.setText(recipe.get_name());
        nameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        nameView.setTextColor(Color.BLACK);
        nameView.setPadding(0,0,20,0);
        nameView.setMaxWidth(900);

        descriptionView.setText(recipe.get_desription());
        descriptionView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        descriptionView.setTextColor(Color.BLACK);

        imageView.setImageBitmap(recipe.get_fotoRecipe());

        editImageView.setImageResource(R.drawable.edit_icon);
        editImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EditActivity.class);

                i.putExtra("0",Integer.toString(recipe.get_id()));
                Log.d("ID!!!!!!!!!!:    ",Integer.toString(recipe.get_id()));
                startActivity(i);
            }
        });


        deleteImageView.setImageResource(R.drawable.remove_icon);

        horizLL.addView(nameView);
        horizLL.addView(editImageView,imagesView);
        horizLL.addView(deleteImageView,imagesView);

        view.addView(horizLL, params);
        view.addView(descriptionView, params);
        view.addView(imageView, params);
        view.addView(viewView,paramsView);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.goBackShowRecipleActivity) {
            Intent intentCancel = new Intent(this, MainActivity.class);
            startActivity(intentCancel);
            finish();
        }
    }
}
