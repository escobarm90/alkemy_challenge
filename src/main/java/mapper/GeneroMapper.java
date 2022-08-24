package mapper;


import dto.GeneroDTO;
import entity.GeneroEntity;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {

    public GeneroMapper(){
        System.out.println("Constructor Genero Mapper");
    };

    public GeneroEntity toEntity(GeneroDTO generoDTO){
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(generoEntity.getNombre());
        generoEntity.setNombre(generoDTO.getNombre());
        generoEntity.setPersonajes_asociados(generoDTO.getPersonajes_asociados());
        return generoEntity;
    }
}
