package ru.startandroid.cookingbook;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    LinearLayout relativeLayoutShowRecipleActivity;
    Button goBackShowRecipleActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes);

        scrollViewShowRecipleActivity = (ScrollView) findViewById(R.id.scrollViewShowRecipleActivity);
        relativeLayoutShowRecipleActivity = (LinearLayout) findViewById(R.id.relativeLayoutShowRecipleActivity);
        goBackShowRecipleActivity = (Button) findViewById(R.id.goBackShowRecipleActivity);

        goBackShowRecipleActivity.setOnClickListener(this);

        DatabaseRecipe dB = new DatabaseRecipe(this);

        allRecipes = dB.getAllContacts();
        String[] allNames = new String[dB.countRecipes];

        int i = 0;
        for (Recipe recipe : allRecipes) {
            formRecipe(relativeLayoutShowRecipleActivity,recipe,i);
            i++;
        }

    }


    public void formRecipe(LinearLayout view, Recipe recipe,int id)
    {
        TextView nameView = new TextView(this);
        TextView descriptionView = new TextView(this);
        ImageView imageView = new ImageView(this);

        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(30, 0, 0, 0);

//        RelativeLayout.LayoutParams paramsDescription=new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        paramsDescription.setMargins(30, 0, 0, 0);
//
//        RelativeLayout.LayoutParams paramsFoto=new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        paramsFoto.setMargins(30, 0, 0, 0);

        nameView.setText(recipe.get_name());
        descriptionView.setText(recipe.get_desription());
        imageView.setImageBitmap(recipe.get_fotoRecipe());

        view.addView(nameView,params);
        view.addView(descriptionView,params);
        view.addView(imageView,params);

    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.goBackShowRecipleActivity){
            Intent intentCancel = new Intent(this, MainActivity.class);
            startActivity(intentCancel);
            finish();
        }
    }
}
