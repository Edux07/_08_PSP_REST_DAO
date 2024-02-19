package com.example._08_psp_rest_dao.Persistencia;

import com.example._08_psp_rest_dao.Entity.Videojuego;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoVideojuego {
    public List<Videojuego> listaVideojuegos;
    public int contador;

    public DaoVideojuego() {
        System.out.println("Creando el DaoVideojuego");
        listaVideojuegos = new ArrayList<Videojuego>();
        Videojuego v1 = new Videojuego(contador++, "The legend of Zelda", "Nintendo", 10);
        Videojuego v2 = new Videojuego(contador++, "Super Mario Bros", "Nintendo", 9);
        Videojuego v3 = new Videojuego(contador++, "FIFA 22", "EA", 8);
        Videojuego v4 = new Videojuego(contador++, "Call of Duty", "Activision", 7);
        Videojuego v5 = new Videojuego(contador++, "Assasins Creed", "Ubisoft", 6);
        listaVideojuegos.add(v1);
        listaVideojuegos.add(v2);
        listaVideojuegos.add(v3);
        listaVideojuegos.add(v4);
        listaVideojuegos.add(v5);
    }

    public Videojuego get(int posicion) {
        try {
            return listaVideojuegos.get(posicion);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public List<Videojuego> list() {
        return listaVideojuegos;
    }


    public void add(Videojuego v) {
        v.setId(contador++);
        listaVideojuegos.add(v);
    }

    public Videojuego delete(int posicion) {
        try {
            return listaVideojuegos.remove(posicion);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    public Videojuego update(Videojuego v) {
        try {
           Videojuego Vaux = listaVideojuegos.get(v.getId());
           if(Vaux != null){
               Vaux.setNombre(v.getNombre());
               Vaux.setCompañía(v.getCompañía());
               Vaux.setNota(v.getNota());
           }
           return v;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    public List<Videojuego> listByName(String nombre) {
        List<Videojuego> lista = new ArrayList<Videojuego>();
        for (Videojuego v : listaVideojuegos) {
            if (v.getCompañía().equals(nombre)) {
                lista.add(v);
            }
        }

        return lista;
    }
}