package dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Pelicula_serieDTO {
    private String imagen;
    private String titulo;
    private Date fecha_creacion;
    private Integer calificacion;

}
