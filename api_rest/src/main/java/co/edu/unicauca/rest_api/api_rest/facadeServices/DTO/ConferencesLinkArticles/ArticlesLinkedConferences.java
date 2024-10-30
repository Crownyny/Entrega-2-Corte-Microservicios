package co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.ConferencesLinkArticles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.CRUDConferencesDTO.ArticleDTO;


import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class ArticlesLinkedConferences {
    private ArticleDTO article;
    private List<ConferenceDTO> conferences;
}
