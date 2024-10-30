package co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.MailMessageDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {
    private int id;
    private String nombre;
    private String autores[];
    private int idConferences[];
    public ArticleDTO(){
            
    }
}
