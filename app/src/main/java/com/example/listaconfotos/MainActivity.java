package com.example.listaconfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.listaconfotos.Adaptadores.AdaptadorUsuario;
import com.example.listaconfotos.Modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Webservice.Asynchtask;
import Webservice.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = (ListView)findViewById(R.id.listusuario);
        View header = getLayoutInflater().inflate(R.layout.ldheaderusuarios, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this,MainActivity.this );
        ws.execute("GET");


    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray JSONlistaUsuarios= new JSONArray(result);
        ArrayList<Usuario>lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadorUsuario adapatorUsuario = new AdaptadorUsuario(this,lstUsuarios );
        lstOpciones.setAdapter(adapatorUsuario);

    }
}