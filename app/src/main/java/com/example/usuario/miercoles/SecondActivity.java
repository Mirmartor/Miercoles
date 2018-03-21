package com.example.usuario.miercoles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    findViewById(R.id.buttonACancel).setOnClickListener(this);
    findViewById(R.id.buttonAVolver).setOnClickListener(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast toast;

        Intent recepcion=getIntent();



        if(recepcion!=null){
            String mensaje= recepcion.getStringExtra("mensaje");
            toast=Toast.makeText(SecondActivity.this,mensaje,Toast.LENGTH_LONG);
        }else{
            toast=Toast.makeText(SecondActivity.this,"no vengo del main",Toast.LENGTH_LONG);
        }
        toast.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        case R.id.buttonAVolver:
            setResult(int RESULT_VOLVER=10);
            break;
        case R.id.buttonACancel:
            setResult(RESULT_CANCELED);
            break;
        }
        finish();
    }
}
