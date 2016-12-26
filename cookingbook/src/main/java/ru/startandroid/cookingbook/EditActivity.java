package ru.startandroid.cookingbook;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    Recipe recipe;
    EditText name_textEditRecipeActivity;
    EditText description_textEditRecipeActivity;
    ImageView fotoEditRecipeActivity;
    Button add_fotoEditRecipeActivity;
    Button add_recipe_submitEditRecipeActivity;
    Button cancelEditRecipeActivity;

    Bitmap fotoRecipe = null;

    private static int RESULT_LOAD_IMAGE = 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);


        Bundle extras = getIntent().getExtras();
        int id = 0;
        if (extras != null) {
            try {

                id = Integer.parseInt(extras.getString("0"));
            } catch (Exception e) {
                Log.d("EXCEPTION: ", e.toString());
                throw e;
            }
        }
        DatabaseRecipe dB = new DatabaseRecipe(this);
        recipe = dB.getRecipe(id);

        name_textEditRecipeActivity = (EditText) findViewById(R.id.name_textEditRecipeActivity);
        description_textEditRecipeActivity = (EditText) findViewById(R.id.description_textEditRecipeActivity);

        fotoEditRecipeActivity = (ImageView) findViewById(R.id.fotoEditRecipeActivity);

        add_fotoEditRecipeActivity = (Button) findViewById(R.id.add_fotoEditRecipeActivity);
        cancelEditRecipeActivity = (Button) findViewById(R.id.cancelEditRecipeActivity);
        add_recipe_submitEditRecipeActivity = (Button) findViewById(R.id.add_recipe_submitEditRecipeActivity);
        name_textEditRecipeActivity.setText(recipe.get_name());
        description_textEditRecipeActivity.setText(recipe.get_desription());
        fotoEditRecipeActivity.setImageBitmap(recipe.get_fotoRecipe());


        cancelEditRecipeActivity.setOnClickListener(this);
        add_recipe_submitEditRecipeActivity.setOnClickListener(this);
        add_fotoEditRecipeActivity.setOnClickListener(this);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            Log.d("Image Here: ", picturePath);
            cursor.close();
            Bitmap myBitmap = BitmapFactory.decodeFile(picturePath);


            fotoRecipe = BitmapFactory.decodeFile(picturePath);
            fotoEditRecipeActivity.setImageBitmap(fotoRecipe);

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add_fotoEditRecipeActivity:
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
                break;
            case R.id.add_recipe_submitEditRecipeActivity:
                recipe.set_name(name_textEditRecipeActivity.getText().toString());
                recipe.set_desription(description_textEditRecipeActivity.getText().toString());
                recipe.set_fotoRecipe(fotoRecipe);

                DatabaseRecipe dB = new DatabaseRecipe(this);
                dB.updateContact(recipe);
                Intent intent = new Intent(this, ShowRecipleActivity.class);
                startActivity(intent);
                finish();

                break;
            case R.id.cancelEditRecipeActivity:
                Intent intentCancel = new Intent(this, ShowRecipleActivity.class);
                startActivity(intentCancel);
                finish();
                break;
        }

    }
}
