package com.example.partyu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
public class BDHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "partyu.db";
    private static final String TABLE_NAME = "festa";
    private static final String COLUM_ID = "id";
    private static final String COLUM_NOME = "nomeFesta";
    private static final String COLUM_DESCRICAO = "descricao";
    private static final String COLUM_PRECO = "Preco";
    private static final String COLUM_ENDERECO = "Endereco";
    private static final String COLUM_LATI ="Latitude";
    private static final String COLUM_LONGI ="Longitude";
    private static final String COLUM_DATA = "Data";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table festa" +"(id integer primary key autoincrement," +
            " nomeFesta text not null, descricao text not null, preco real not null, endereco text not null, latitude real not null, longitude real not null, data date not null);";
    public BDHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }
    public void insereFesta(Festa f){
        db=this.getWritableDatabase();
        ContentValues values=  new ContentValues();
        values.put(COLUM_NOME, f.getNomeFesta());
        values.put(COLUM_DESCRICAO, f.getDescricao());
        values.put(COLUM_ENDERECO, f.getEndereco());
        values.put(COLUM_PRECO, f.getPreco());
        values.put(COLUM_LATI, f.getLatitude());
        values.put(COLUM_LONGI, f.getLongitude());
        values.put(COLUM_DATA, f.getDate());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Double buscarLatitude(String nome){
        db = this.getReadableDatabase();
        String query = "select latitude from "+ TABLE_NAME+"where nomeFesta = "+nome;
        Cursor cursor = db.rawQuery(query, null);
        Double a=0.0;
        cursor.moveToFirst();
        return a = Double.parseDouble(cursor.getString(0));
    }
    public Double buscarLongitude(String nome){
        db = this.getReadableDatabase();
        String query = "select longitude from "+ TABLE_NAME+"where nomeFesta = "+nome;
        Cursor cursor = db.rawQuery(query, null);
        Double a=0.0;
        cursor.moveToFirst();
        return a = Double.parseDouble(cursor.getString(0));
    }
    public ArrayList<Festa> selectAllFestas(){
        String [] column= {COLUM_NOME, COLUM_ENDERECO, COLUM_DESCRICAO, COLUM_PRECO, COLUM_DATA};
        Cursor cursor = getReadableDatabase().query(TABLE_NAME, column, null, null, null, null, "upper(nome)");
        ArrayList<Festa> listaFesta = new ArrayList<Festa>();
        while (cursor.moveToNext()){
            Festa c = new Festa();
            c.setNomeFesta(cursor.getString(0));
            c.setEndereco(cursor.getString(1));
            c.setDescricao(cursor.getString(2));
            c.setPreco(cursor.getString(3));
            c.setDate(cursor.getString(4));
            listaFesta.add(c);
        }
        return listaFesta;
    }

}
