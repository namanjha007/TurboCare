package com.example.bizlerstechnologies;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    private static final int PICK_IMG = 100;
    private Button button1, button2, button3;
    private EditText editText1, editText2, editText3, editText4;
    private Bitmap ImageList;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);

        myDB = new DatabaseHelper(this);
        myDB.getWritableDatabase();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed1 = editText1.getText().toString();
                String ed2 = editText2.getText().toString();
                String ed3 = editText3.getText().toString();
                String ed4 = editText4.getText().toString();
                if(editText1.length()==0)
                    editText1.setError("Field is empty!");
                else if(editText2.length()==0)
                    editText2.setError("Field is empty!");
                else if(editText3.length()==0)
                    editText3.setError("Field is empty!");
                else if(editText4.length()==0)
                    editText4.setError("Field is empty!");
                else if(imageUri.toString().length()==0)
                    Toast.makeText(MainActivity.this, "Add Image", Toast.LENGTH_SHORT).show();
                else
                {
                    AddData1(ed1,ed2,ed3,ed4,imageUri.toString());
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });
    }

    public void button3(View view) {
        //we will pick images
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent, PICK_IMG);
    }

    private void AddData1(String ed1, String ed2, String ed3, String ed4, String image) {
        boolean insertData = myDB.addData(ed1, ed2, ed3, ed4, image);

        if(insertData)
            Toast.makeText(MainActivity.this,"Insertion Successful",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMG) {
            if (resultCode == RESULT_OK) {
                if (data.getData() != null) {

                    imageUri = data.getData();

                }

            }

        }

    }
}
