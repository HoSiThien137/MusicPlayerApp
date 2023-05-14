package com.example.musicplayerapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.musicplayerapp.R;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText login_username, login_password;
    private Button login_button;
    private TextView signupRedirectText;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_username = findViewById(R.id.login_username);
        login_password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);
        signupRedirectText = findViewById(R.id.signupRedirectText);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = login_username.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                // Gọi hàm kiểm tra đăng nhập
                login(username, password);
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình đăng ký
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(String username, String password) {
        String url = "https://highfive-app.000webhostapp.com/Server/login.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("success")) {
                            // Đăng nhập thành công
                            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            // Chuyển sang màn hình chính
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // Đăng nhập thất bại
                            Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                // Lấy giá trị từ EditText
                String username = login_username.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                // Đưa giá trị vào Map
                params.put("username", username);
                params.put("password", password);

                return params;
            }
        };
    }
}