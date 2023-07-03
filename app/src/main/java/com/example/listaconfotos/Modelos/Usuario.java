package com.example.listaconfotos.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Usuario {
    private String nombres;
    private String email;
    private String website;
    private String urlavatar;
    public Usuario(JSONObject a) throws JSONException {
        nombres = a.getString("journal_id").toString();
        email = a.getString("name").toString() ;
        website = a.getString("abbreviation").toString() ;
        urlavatar = a.getString("portada").toString() ;
    }
    public static ArrayList<Usuario> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            usuarios.add(new Usuario(datos.getJSONObject(i)));
        }
        return usuarios;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUrlavatar() {
        return urlavatar;
    }

    public void setUrlavatar(String urlavatar) {
        this.urlavatar = urlavatar;
    }
}

