package com.salvador.mariscal.examencasopractico.modelo;

import android.content.Context;
import android.database.Cursor;

public class Platos {

    private int id;
    private String nombre;
    private String tipo;
    private String ingredientes;
    private double costo;
    private double PVP;

    public Platos() {

    }

    public Platos(int id, String nombre, String tipo, String ingredientes, double costo, double PVP) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ingredientes = ingredientes;
        this.costo = costo;
        this.PVP = PVP;
    }

    //MODELO
    public void guardarGestion(Context context){
        String sql="INSERT INTO 'Restaurant' (nombre,tipo,ingredientes,costo,PVP)";
        sql+="VALUES ('"+getNombre()+"','"+getTipo()+"','"+getIngredientes()+"','"+getCosto()+"','"+getPVP()+"')";
        BaseSQLiteHelper baseSQLiteHelper= new BaseSQLiteHelper(context);
        baseSQLiteHelper.getWritableDatabase().execSQL(sql);
    }

    public static Cursor listaGestion(Context context){
        String sql="select _rowid_ as _id, * from Restaurant";
        BaseSQLiteHelper sqLiteHelper= new BaseSQLiteHelper(context);
        return sqLiteHelper.getReadableDatabase().rawQuery(sql,null);

    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPVP() {
        return PVP;
    }

    public void setPVP(double PVP) {
        this.PVP = PVP;
    }
}
