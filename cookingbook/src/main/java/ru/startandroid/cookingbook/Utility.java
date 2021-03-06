package ru.startandroid.cookingbook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class Utility {
    // convert from bitmap to byte array
    static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    // convert from byte array to bitmap
    static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public static boolean checkRecipeObj(Recipe objRecipe) {
        if (objRecipe.get_name() == null) {
            return false;
        }
        else if(objRecipe.get_desription() == null){
            return false;
        }
        else if(objRecipe.get_fotoRecipe() == null){
            return false;
        }

        return true;
    }
}
