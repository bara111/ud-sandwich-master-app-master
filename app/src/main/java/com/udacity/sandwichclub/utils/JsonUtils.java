package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich=new Sandwich();
        try {
            JSONObject root = new JSONObject(json);
            JSONObject name = root.getJSONObject("name");
            String mainName = name.getString("mainName");
            sandwich.setMainName(mainName);
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alsoKnownList.add(alsoKnownAs.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownList);
            String placeOfOrigin = root.getString("placeOfOrigin");
            if(placeOfOrigin!=null){
                sandwich.setPlaceOfOrigin(placeOfOrigin);
            }
            String description = root.getString("description");
            if(description!=null){
                sandwich.setDescription(description);
            }
            String image = root.getString("image");
            if (image != null) {
                sandwich.setImage(image);
            }
            JSONArray ingredients = root.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }
            sandwich.setIngredients(ingredientsList);




        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
