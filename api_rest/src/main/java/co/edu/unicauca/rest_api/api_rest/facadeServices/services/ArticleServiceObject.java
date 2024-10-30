package co.edu.unicauca.rest_api.api_rest.facadeServices.services;

import co.edu.unicauca.rest_api.api_rest.dataAccessLayer.models.ArticleEntity;
import co.edu.unicauca.rest_api.api_rest.dataAccessLayer.repositories.ArticleRepository;
import co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.CRUDConferencesDTO.ArticleDTO;
import co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.ConferencesLinkArticles.*;
import co.edu.unicauca.rest_api.api_rest.rabbit.MessageProducer;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ArticleServiceObject implements IArticleService{
    private final ArticleRepository databaseAccessService;
    private final ConferenceService conferenceService;
    private final ModelMapper modelMapper;
    private final MessageProducer producer;


    @Override
    public List<ArticleDTO> getAll()
    {
        List<ArticleEntity> articleEntities = databaseAccessService.getAll();
        List<ArticleDTO> articleDTOs = modelMapper.map(articleEntities, new TypeToken<List<ArticleDTO>>(){}.getType());
        return articleDTOs;
    }

    @Override
    public ArticleDTO getByID(int id) {
        ArticleEntity articleEntity = databaseAccessService.getById(id);
        ArticleDTO articleDTO = modelMapper.map(articleEntity, ArticleDTO.class);
        return articleDTO;
    }

    @Override
    public ArticleDTO add(ArticleDTO article) {
        ArticleEntity articleEntity = modelMapper.map(article, ArticleEntity.class);
        databaseAccessService.add(articleEntity);
        producer.sendMessage(article);
        return article;
    }

    @Override
    public ArticleDTO update(int id, ArticleDTO article) {
        ArticleEntity articleEntity = modelMapper.map(article, ArticleEntity.class);
        ArticleEntity updatedArticleEntity = databaseAccessService.update(id, articleEntity);
        ArticleDTO updatedArticleDTO = modelMapper.map(updatedArticleEntity, ArticleDTO.class);
        return updatedArticleDTO;
    }

    @Override
    public boolean delete(int id) {
        return databaseAccessService.delete(id);
    }

    @Override
    public boolean exists(int id) {
        return databaseAccessService.exists(id);
    }

    @Override
    public ArticlesLinkedConferences getConferencesOfArticles(int idArticle) {
        List<ConferenceDTO> conferences = conferenceService.getConferencesOfArticles(idArticle);
        ArticleEntity articleEntity = databaseAccessService.getById(idArticle);
        ArticleDTO articleDTO = modelMapper.map(articleEntity, ArticleDTO.class);
        
        return new ArticlesLinkedConferences(articleDTO, conferences); 
    }
}
