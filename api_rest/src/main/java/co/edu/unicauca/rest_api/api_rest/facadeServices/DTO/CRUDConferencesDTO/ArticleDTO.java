package co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.CRUDConferencesDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {
    private int id;
    private String nombre;
    private String autores;
    private int cantidadAutores;
    private String revista;
    private List<ConferenceDTO> conferences;

    public ArticleDTO() {
    }
}
