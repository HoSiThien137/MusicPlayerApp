package com.example.musicplayerapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.musicplayerapp.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class SignUpActivity extends AppCompatActivity {

    private EditText signup_fullname;
    private EditText signup_phonenumber;
    private EditText signup_username;
    private EditText signup_password;
    private Button signup_button;
    private TextView loginRedirectText;



    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup_fullname = findViewById(R.id.signup_fullname);
        signup_phonenumber = findViewById(R.id.signup_phonenumber);
        signup_username = findViewById(R.id.signup_username);
        signup_password = findViewById(R.id.signup_password);
        signup_button = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                    String fullname = signup_fullname.getText().toString();
                    String phone = signup_phonenumber.getText().toString();
                    String username = signup_username.getText().toString();
                    String password = signup_password.getText().toString();

                    //Đăng ký tài khoản
                    registerAccount(fullname, phone, username, password);
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình đăng nhập
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


/*
        CreateDatabase createDatabase;
        createDatabase = new CreateDatabase(this);
        createDatabase.open(); */
    }
    private void registerAccount(String fullname, String phone, String username, String password) {
        // Tạo kết nối tới cơ sở dữ liệu MySQL trên phpMyAdmin
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/id20579369_appmusic", "id20579369_highfive", "Highfive00@");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Thực hiện truy vấn để chèn dữ liệu đăng ký vào bảng tài khoản
        if (conn != null) {
            try {
                // Tạo câu truy vấn SQL
                String query = "INSERT INTO Account (Name, SDT, Username, Password) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(query);

                // Đặt giá trị cho các tham số trong câu truy vấn
                statement.setString(1, fullname);
                statement.setString(2, phone);
                statement.setString(3, username);
                statement.setString(4, password);

                // Thực thi câu truy vấn INSERT
                int rowsInserted = statement.executeUpdate();

                // Kiểm tra xem có bản ghi được chèn thành công hay không
                if (rowsInserted > 0) {
                    Toast.makeText(SignUpActivity.this, "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();

                    // Thực hiện các thao tác khác sau khi đăng ký thành công (ví dụ: chuyển đến màn hình đăng nhập)
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignUpActivity.this, "Đăng ký tài khoản thất bại", Toast.LENGTH_SHORT).show();
                }

                // Đóng kết nối và giải phóng tài nguyên
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}