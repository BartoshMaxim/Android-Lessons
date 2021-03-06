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
import android.widget.TextView;


public class AddRecipeActivity extends AppCompatActivity implements View.OnClickListener {

    Button add_recipe_submit;
    Button add_foto;
    Button cancel;

    TextView name_recipe_label;
    TextView description_recipe_label;

    EditText name_text;
    EditText description_text;

    Recipe objRecipe;

    private static int RESULT_LOAD_IMAGE = 1;

    Bitmap fotoRecipe =null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);

        add_recipe_submit = (Button) findViewById(R.id.add_recipe_submitAddRecipeActivity);
        name_text = (EditText) findViewById(R.id.name_textAddRecipeActivity);
        description_text = (EditText) findViewById(R.id.description_textAddRecipeActivity);
        add_foto = (Button) findViewById(R.id.add_fotoAddRecipeActivity);
        cancel = (Button) findViewById(R.id.cancelAddRecipeActivity);
        add_recipe_submit.setOnClickListener(this);
        add_foto.setOnClickListener(this);
        cancel.setOnClickListener(this);

        objRecipe = new Recipe();
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
            Log.d("!!!!!!!!!!!!!!!!!!!",picturePath);
            cursor.close();
            fotoRecipe=BitmapFactory.decodeFile(picturePath);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_fotoAddRecipeActivity:
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
                break;
            case R.id.add_recipe_submitAddRecipeActivity:
                objRecipe.set_name(name_text.getText().toString());
                objRecipe.set_desription(description_text.getText().toString());
                objRecipe.set_fotoRecipe(fotoRecipe);
                if(fotoRecipe==null)
                {
                    add_recipe_submit.setText("Ooops");
                }
                else{
                    DatabaseRecipe dB = new DatabaseRecipe(this);
                    dB.addRecipe(objRecipe);
                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                //if (Utility.checkRecipeObj(objRecipe)) {

               // } else {
                //    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //    builder.setMessage(R.string.fill_form);
                //    builder.create();
               //}
                break;
            case R.id.cancelAddRecipeActivity:
                Intent intentCancel = new Intent(this, MainActivity.class);
                startActivity(intentCancel);
                finish();
                break;

        }
    }
}
