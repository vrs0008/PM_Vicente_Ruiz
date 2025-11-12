package com.example.practica_5_listas_optimizadas;

public class Games {
    private String title;
    private String image;
    private String genero;
    private int edad;

    public Games(String title, String image, String genero, int edad) {
        this.title = title;
        this.image = image;
        this.genero = genero;
        this.edad = edad;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
