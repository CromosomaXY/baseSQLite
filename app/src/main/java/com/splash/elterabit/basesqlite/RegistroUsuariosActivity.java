package com.splash.elterabit.basesqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroUsuariosActivity extends AppCompatActivity{

    EditText campoId, campoNombre, campoTelefono;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoId = findViewById(R.id.campoId);
        campoNombre = findViewById(R.id.campoNombre);
        campoTelefono = findViewById(R.id.campoTelefono);
    }

    public void onClick(View view){
        registrarUsuarios();
        //consulta con insert into
        //registrarUsuariosSql();

    }


    private void registrarUsuariosSql(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        String insert = "INSERT INTO " + Utilidades.TABLA_USUARIO
                + "("+Utilidades.CAMPO_ID+", "+Utilidades.CAMPO_NOMBRE+", "+Utilidades.CAMPO_TELEFONO+") " +
                "values ("+campoId.getText().toString()+", '"+campoNombre.getText().toString()+"', '"+campoTelefono.getText().toString()+"')";
        db.execSQL(insert);

        Toast.makeText(getApplicationContext(), "Insert correcto", Toast.LENGTH_SHORT).show();

        db.close();
    }


    private void registrarUsuarios(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_ID, campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, campoTelefono.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);
        Toast.makeText(getApplicationContext(), "Id Registro: " + idResultante, Toast.LENGTH_SHORT).show();
        db.close();


    }


}
