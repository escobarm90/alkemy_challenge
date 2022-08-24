package entity;

import dto.Pelicula_serieDTO;

import java.util.ArrayList;
import java.util.List;

public class GeneroEntity {
    private String nombre;
    private String imagen;
    private List<Pelicula_serieDTO> personajes_asociados = new ArrayList<Pelicula_serieDTO>();

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public List<Pelicula_serieDTO> getPersonajes_asociados() {
        return personajes_asociados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setPersonajes_asociados(List<Pelicula_serieDTO> personajes_asociados) {
        this.personajes_asociados = personajes_asociados;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", personajes_asociados=" + personajes_asociados +
                '}';
    }
}
