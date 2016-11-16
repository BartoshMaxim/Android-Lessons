package ru.startandroid.cookingbook;

import android.graphics.Bitmap;


public class Recipe {

    int _id;
    String _name;
    String _desription;
    Bitmap _fotoRecipe;

    public Recipe() {
        _name = null;
        _desription = null;
        _fotoRecipe = null;
    }

    public Recipe(int id, String name, String desription, Bitmap fotoRecipe) {
        this._id = id;
        this._name = name;
        this._desription = desription;
        this._fotoRecipe = fotoRecipe;
    }

    public Recipe(String desription, String name, Bitmap fotoRecipe) {
        this._name = name;
        this._desription = desription;
        this._fotoRecipe = fotoRecipe;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public String get_desription() {
        return _desription;
    }

    public Bitmap get_fotoRecipe() {
        return _fotoRecipe;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_desription(String _desription) {
        this._desription = _desription;
    }

    public void set_fotoRecipe(Bitmap _fotoRecipe) {
        this._fotoRecipe = _fotoRecipe;
    }
}
