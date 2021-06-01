package com.example.nguyenviettuan_thithu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    EditText txtEmal,txtPass;
    Button btnLogin;
    TextView txtGotoSignUP;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmal = findViewById(R.id.txtEmailLogin);
        txtPass = findViewById(R.id.txtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmal.getText().toString().trim();
                String pass = txtPass.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    txtEmal.setError("Nhap Email");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    txtPass.setError("Nhap Pass");
                    return;
                }
                if(pass.length() < 6)
                {
                    txtPass.setError("Nhap Pass >= 6");
                    return;
                }

                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
                        }else {
                            Toast.makeText(MainActivity.this,"Thất bại : " + task.getException() ,Toast.LENGTH_LONG).show();
                            Log.e("errr: ",task.getException().toString());
                        }
                    }
                });
            }
        });
    }
}