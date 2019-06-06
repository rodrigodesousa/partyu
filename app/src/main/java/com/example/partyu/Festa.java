package com.example.partyu;

public class Festa {
    String id, nomeFesta, descricao, endereco, preco, date, latitude, longitude;

    public Festa(){

    }

    public Festa(String id, String nomeFesta, String descricao, String endereco, String preco, String date, String latitude, String longitude) {
        this.id = id;
        this.nomeFesta = nomeFesta;
        this.descricao = descricao;
        this.endereco = endereco;
        this.preco = preco;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeFesta() {
        return nomeFesta;
    }

    public void setNomeFesta(String nomeFesta) {
        this.nomeFesta = nomeFesta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
