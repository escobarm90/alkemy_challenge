package entity;

import dto.Pelicula_serieDTO;

import java.util.ArrayList;
import java.util.List;

public class PersonajeEntity {
    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;
    private List<Pelicula_serieDTO> personajes_asociados = new ArrayList<Pelicula_serieDTO>();

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getPeso() {
        return peso;
    }

    public String getHistoria() {
        return historia;
    }

    public List<Pelicula_serieDTO> getPersonajes_asociados() {
        return personajes_asociados;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public void setPersonajes_asociados(List<Pelicula_serieDTO> personajes_asociados) {
        this.personajes_asociados = personajes_asociados;
    }

    @Override
    public String toString() {
        return "PersonajeEntity{" +
                "imagen='" + imagen + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", historia='" + historia + '\'' +
                ", personajes_asociados=" + personajes_asociados +
                '}';
    }
}
