package com.splash.elterabit.basesqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
    }


    public void onClick(View view){
        Intent miIntent =  null;

        switch (view.getId()){

            case R.id.btnRegistro:
                miIntent = new Intent(MainActivity.this, RegistroUsuariosActivity.class);
                break;

            case R.id.btnConsultaUser:
                miIntent = new Intent(MainActivity.this, ConsultarUsuariosActivity.class);
                break;

            case R.id.btnListaSpinner:
                miIntent = new Intent(MainActivity.this, ConsultaComboActivity.class);
                break;

            case R.id.btnListaListView:
                miIntent = new Intent(MainActivity.this, ConsultarListaListViewActivity.class);
                break;
        }

        if(miIntent!=null){
            startActivity(miIntent);
        }
    }
}
