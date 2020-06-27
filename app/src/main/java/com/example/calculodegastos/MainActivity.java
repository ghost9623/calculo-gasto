package com.example.calculodegastos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editusuario;
    private EditText editpsalida;
    private EditText editpllegada;
    private EditText edithorasalida;
    private EditText editcostogaso;
    private EditText editdistanciakm;
    private EditText edittiemlleg;
    private EditText editcostviaj;
    private Button   btncalcular;
    viaje v= new viaje();

    public void enlazar()
    {
        editusuario=(EditText)findViewById(R.id.editUsuario);
        editpsalida=(EditText)findViewById(R.id.editPsalida);
        editpllegada=(EditText)findViewById(R.id.editPllegasda);
        edithorasalida=(EditText)findViewById(R.id.editHora);
        editcostogaso=(EditText)findViewById(R.id.editGaso);
        editdistanciakm=(EditText)findViewById(R.id.editKM);
        edittiemlleg=(EditText)findViewById(R.id.editTiemlleg);
        editcostviaj=(EditText)findViewById(R.id.editCostoviaje);
        btncalcular=(Button)findViewById(R.id.btncalcular);

    }


    public void app()
    {enlazar();

      btncalcular.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              try {
                  calcular();
                  mostramensaje();
              }
              catch (Exception e)
              {
                  Toast.makeText(getApplicationContext(),"ingrese un numero",Toast.LENGTH_SHORT).show();
              }

          }
      });
    }

    public void calcular()
    {
        v.setNombre(editusuario.getText().toString());
        v.setSalida(editpsalida.getText().toString());
        v.setLlegada(editpllegada.getText().toString());
        v.setCostogaso(Double.parseDouble(editcostogaso.getText().toString()));
        v.setHorasalida(edithorasalida.getText().toString());
        v.setDiskm(Double.parseDouble(editdistanciakm.getText().toString()));

        edittiemlleg.setText(String.valueOf(v.tiempollegada()));
        editcostviaj.setText(String.valueOf(v.costoviaje()));

    }
    public void mostramensaje()
    {
        new AlertDialog.Builder(this)
                .setTitle("exit")
                .setMessage("La opercion ha sido un exito "+editusuario.getText().toString()+"\nEl viaje ha sido de "+editpsalida.getText().toString()+" a "+editpllegada.getText().toString()+"\n Tiempo de salida es de "+edithorasalida.getText().toString())


                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app();
    }
}
