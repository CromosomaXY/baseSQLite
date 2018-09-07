package com.splash.elterabit.basesqlite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.splash.elterabit.basesqlite.com.entidades.Usuario;

public class DetalleUsuarioActivity extends AppCompatActivity{

    TextView campoId, campoNombre, campoTelefono;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        campoId = findViewById(R.id.campoId);
        campoNombre = findViewById(R.id.campoNombre);
        campoTelefono = findViewById(R.id.campoTelefono);

        Bundle objetoEnviado = getIntent().getExtras();
        Usuario user = null;

        if(objetoEnviado != null){
            user = (Usuario) objetoEnviado.getSerializable("usuario");
            campoId.setText(user.getId().toString());
            campoNombre.setText(user.getNombre().toString());
            campoTelefono.setText(user.getTelefono().toString());
        }







    }
}
