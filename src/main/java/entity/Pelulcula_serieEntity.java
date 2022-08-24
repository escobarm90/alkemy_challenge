package entity;

import dto.PersonajeDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pelulcula_serieEntity {
    private String imagen;
    private String titulo;
    private Date fecha_creacion;
    private Integer calificacion;
    private List<PersonajeDTO> personajes_asociados = new ArrayList<PersonajeDTO>();

    public String getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public List<PersonajeDTO> getPersonajes_asociados() {
        return personajes_asociados;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public void setPersonajes_asociados(List<PersonajeDTO> personajes_asociados) {
        this.personajes_asociados = personajes_asociados;
    }

    @Override
    public String toString() {
        return "Pelulcula_serie{" +
                "imagen='" + imagen + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", calificacion=" + calificacion +
                ", personajes_asociados=" + personajes_asociados +
                '}';
    }
}
