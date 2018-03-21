package com.example.usuario.miercoles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    findViewById(R.id.buttonBCancel).setOnClickListener(this);
    findViewById(R.id.buttonBVolver).setOnClickListener(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toast toast;

        Intent respuesta=new Intent;



        if(recepcion!=null){
            String mensaje= recepcion.getStringExtra("mensaje");
            toast=Toast.makeText(ThirdActivity.this,mensaje,Toast.LENGTH_LONG);
        }else{
            toast=Toast.makeText(ThirdActivity.this,"no vengo del main",Toast.LENGTH_LONG);
        }
        toast.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonBVolver:
                setResult(int RESULT_VOLVER=10);
                break;
            case R.id.buttonBCancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}