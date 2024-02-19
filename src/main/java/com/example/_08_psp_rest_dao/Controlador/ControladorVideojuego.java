package com.example._08_psp_rest_dao.Controlador;

import com.example._08_psp_rest_dao.Entity.Videojuego;
import com.example._08_psp_rest_dao.Persistencia.DaoVideojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

import static org.hibernate.Hibernate.list;


@RestController
public class ControladorVideojuego {
    @Autowired
    private DaoVideojuego daoVideojuego;

    @GetMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Videojuego> getVideojuego(@PathVariable("id") int id) {
        Videojuego videojuego = daoVideojuego.get(id);
        if (videojuego != null) {
            return new ResponseEntity<Videojuego>(videojuego, HttpStatus.OK);
        } else {
            return new ResponseEntity<Videojuego>(videojuego, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(path = "videojuegos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Videojuego> AltaVideojuego(@RequestBody Videojuego videojuego) {
        daoVideojuego.add(videojuego);
        return new ResponseEntity<Videojuego>(videojuego, HttpStatus.CREATED);
    }



    @GetMapping(path = "videojuegos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Videojuego>> listadoVideojuegos(@RequestParam(name = "nombre", required = false) String nombre) {
        List<Videojuego> lista = null;
        if (nombre == null) {
            lista = daoVideojuego.list();
        } else {
            lista = daoVideojuego.listByName(nombre);
        }
        return new ResponseEntity<List<Videojuego>>(lista, HttpStatus.OK);
    }
    @PutMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Videojuego> modificarvideoJuego(@PathVariable("id") int id, @RequestBody Videojuego videojuego){
        Videojuego v = daoVideojuego.get(id);
        if(v != null){
            v.setNombre(videojuego.getNombre());
            v.setCompañía(videojuego.getCompañía());
            v.setNota(videojuego.getNota());
            return new ResponseEntity<Videojuego>(v, HttpStatus.OK);
        }else{
            return new ResponseEntity<Videojuego>(v, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable("id") int id){
        Videojuego v = daoVideojuego.delete(id);
        if(v != null){
            return new ResponseEntity<Videojuego>(v, HttpStatus.OK);
        }else{
            return new ResponseEntity<Videojuego>(v, HttpStatus.NOT_FOUND);
        }
    }
}




