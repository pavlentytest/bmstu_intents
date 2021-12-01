package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ru.samsung.itschool.mdev.myapplication.databinding.ActivityMain2Binding;
import ru.samsung.itschool.mdev.myapplication.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    public static final int MAINACTIVITY2CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            binding.textView2.setText(bundle.getString("val"));
        }


        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ppp",binding.editText2.getText().toString());
                setResult(MAINACTIVITY2CODE,intent);
                finish();
                }
        });

    }
}