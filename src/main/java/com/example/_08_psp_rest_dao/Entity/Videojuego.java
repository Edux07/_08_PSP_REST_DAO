package com.example._08_psp_rest_dao.Entity;





public class Videojuego {

    private int id;

    private String nombre;

    private String compañía;

    private int nota;

    public Videojuego() {
    }

    public Videojuego(int id, String nombre, String compañía, int nota) {
        this.id = id;
        this.nombre = nombre;
        this.compañía = compañía;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompañía() {
        return compañía;
    }

    public void setCompañía(String compañía) {
        this.compañía = compañía;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", compañía='" + compañía + '\'' +
                ", nota=" + nota +
                '}';
    }
}
