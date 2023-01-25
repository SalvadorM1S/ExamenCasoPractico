package com.salvador.mariscal.examencasopractico.modelo;

import android.content.Context;
import android.database.Cursor;

public class gestion {

    private int codigo;
    private String nombre;
    private String tipo;
    private String ingredientes;
    private String costo;
    private String PVP;

    public gestion(int codigo, String nombre, String tipo, String ingredientes, String costo, String PVP) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
        this.costo = costo;
        this.PVP = PVP;
    }

    //MODELO
    public void guardarPersona(Context context){
        String sql="INSERT INTO Restaurant (nombre,tipo,ingredientes,costo,PVP)";
        sql+="VALUES ('"+getNombre()+"','"+getTipo()+"','"+getIngredientes()+"','"+getCosto()+"','"+getPVP()+"')";
        BaseSQLiteHelper baseSQLiteHelper= new BaseSQLiteHelper(context);
        baseSQLiteHelper.getWritableDatabase().execSQL(sql);
    }

    public static Cursor listaPersona(Context context){
        String sql="select _rowid_ as _id, * from persona";
        BaseSQLiteHelper sqLiteHelper= new BaseSQLiteHelper(context);
        return sqLiteHelper.getReadableDatabase().rawQuery(sql,null);

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getPVP() {
        return PVP;
    }

    public void setPVP(String PVP) {
        this.PVP = PVP;
    }
}
