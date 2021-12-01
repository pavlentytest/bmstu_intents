package ru.samsung.itschool.mdev.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import ru.samsung.itschool.mdev.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bind;
    private ActivityResultLauncher<Intent> someActivityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == MainActivity2.MAINACTIVITY2CODE) {
                        Intent data = result.getData();
                        Snackbar.make(bind.root,data.getStringExtra("ppp").toString(),Snackbar.LENGTH_LONG).show();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Намерение - класс Intent
                // Явное (класс активности)
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("val",bind.editText.getText().toString());
                //startActivity(intent);
                someActivityResultLauncher.launch(intent);
            }
        });

    }
}