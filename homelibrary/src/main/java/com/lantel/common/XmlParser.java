package com.lantel.common;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class XmlParser {
    public static String xml2json(String response) {
        JSONObject jsonObj = null;
        try {
            jsonObj = XML.toJSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj.toString();
    }
}
