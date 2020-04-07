package com.helper;

import com.dto.Color;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Helper {

    public static JSONArray listColorToJsonArray (List<Color> colorList) {
        JSONArray jArray = null;

        try {
            jArray = new JSONArray();

            for (Color color : colorList) {
                JSONObject colorJSON = new JSONObject();
                colorJSON.put("color_number", color.getColorNumber());
                colorJSON.put("name", color.getName());
                jArray.put(colorJSON);
            }
        } catch (JSONException jse) {
            jse.printStackTrace();
        }

        return jArray;
    }
}
