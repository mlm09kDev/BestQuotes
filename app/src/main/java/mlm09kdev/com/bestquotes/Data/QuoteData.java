package mlm09kdev.com.bestquotes.Data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mlm09kdev.com.bestquotes.Controller.AppController;
import mlm09kdev.com.bestquotes.Model.Quote;

/**
 * Created by Manuel Montes de Oca on 8/8/2018.
 */
public class QuoteData {
    ArrayList<Quote> arrayList = new ArrayList<>();

    public void getQoutes() {

        String URL = "https://raw.githubusercontent.com/mlm09kDev/BestQuotes/master/quoteArray.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject quoteObject = response.getJSONObject(i);
                        Quote quote = new Quote();
                        quote.setQuote(quoteObject.getString("quote"));
                        quote.setQuote(quoteObject.getString("name"));
                        arrayList.add(quote);
                        Log.d("QuoteData" + i,quoteObject.getString("name" ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
