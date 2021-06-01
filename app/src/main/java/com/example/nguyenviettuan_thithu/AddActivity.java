package com.example.nguyenviettuan_thithu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText txtidzz,txtName;
    Button btnAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        txtidzz = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtName);
        btnAd = findViewById(R.id.btnAdd);

        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
                Toast.makeText(AddActivity.this,"Them thanh cong",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                finish();
            }
        });
    }
    private void add(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://60b092371f26610017ffe77b.mockapi.io/users";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Toast.makeText(AddActivity.this,"Ok",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
            }
        })
            {
                protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> postParam= new HashMap<String, String>();
                postParam.put("id", txtidzz.getText().toString().trim());
                postParam.put("name", txtName.getText().toString().trim());
                return postParam;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}