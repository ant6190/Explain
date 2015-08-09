package com.example.anthony.explain;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 8/9/2015.
 */
public class Requests {

    private String result;

    public void postRequest(Context context,final String description,final Boolean done,final int id,final String title){
        //mPostCommentResponse.requestStarted();
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest sr = new StringRequest(Request.Method.POST,"http://posttestserver.com/post.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //mPostCommentResponse.requestCompleted();
                //mTextView.setText(response);
                result = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mPostCommentResponse.requestEndedWithError(error);
                String errorMessage = error.getMessage();
                if (errorMessage != null) result = error.toString();
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("description", description);
                params.put("done",done.toString());
                params.put("id", id+"");
                params.put("title",title);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("Content-Type","application/json");
                return params;
            }
        };
        queue.add(sr);
    }

    public String getResult(){
        return result;
    }

}
