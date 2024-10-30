package co.edu.unicauca.rest_api.api_rest.facadeServices.services;

import java.util.List;

import co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.CRUDConferencesDTO.ArticleDTO;
import co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.ConferencesLinkArticles.*;


public interface IArticleService {
    
    public List<ArticleDTO> getAll();
    public ArticleDTO getByID(int id);
    public ArticleDTO add(ArticleDTO article);
    public ArticleDTO update(int id,ArticleDTO article);
    public boolean delete(int id);
    public boolean exists(int id);
    public ArticlesLinkedConferences getConferencesOfArticles(int idArticle);
}
