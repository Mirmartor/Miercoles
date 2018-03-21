package com.example.usuario.miercoles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonA;
    private Button buttonB;
    private static final int REQUEST_CODE_A=10;
    private static final int REQUEST_CODE_B=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA=(Button) findViewById(R.id.buttonLlamarA);
        buttonA.setOnClickListener(this);
        buttonB=(Button) findViewById(R.id.buttonLlamarB);
        buttonB.setOnClickListener(this);
        //por ser views podemos usar directamente los botones
        //findViewById(R.id.buttonLlamarA).setOnClickListener(this);
        //findViewById(R.id.buttonLlamarB).setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        Intent intent=null;
        int requestCode;
        switch (view.getId()){
            case R.id.buttonLlamarA:
                intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("mensaje","Vengo del Main y estoy en A");
               requestCode=MainActivity.REQUEST_CODE_A;
                       //startActivityForResult(); Necesita sobre escribir onActivityResult(...)
                break;


            case R.id.buttonLlamarB:
                intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("mensaje","Vengo del Main y estoy en B");
                startActivityForResult(intent,2);
                requestCode=MainActivity.REQUEST_CODE_B;
                break;
        }

        startActivityForResult(intent,requestCode);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast toast=null;

        switch(requestCode){
            case  MainActivity.REQUEST_CODE_A:
                toast=Toast.makeText(this,"respuesta de A",Toast.LENGTH_LONG);
            break;
            case MainActivity.REQUEST_CODE_B:
                toast=Toast.makeText(this,"respuesta de B",Toast.LENGTH_LONG);
            break;

        }
        if (toast!=null) {
            toast.show();
        }



    }
}
