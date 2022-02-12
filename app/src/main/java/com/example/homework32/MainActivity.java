package com.example.homework32;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button_send;
    private EditText address;
    private EditText subject;
    private EditText message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_send = findViewById(R.id.btn_send);
        address = findViewById(R.id.tv_email1);
        subject = findViewById(R.id.tv_theme1);
        message = findViewById(R.id.message1);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "emailto",address.getText().toString(), null));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, address.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                startActivity(Intent.createChooser(emailIntent, "send"));
            }
        });

    }
}