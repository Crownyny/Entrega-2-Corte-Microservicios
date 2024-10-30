package co.edu.unicauca.api_conference.core.dataAccessLayer.repositories;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.api_conference.core.dataAccessLayer.models.ArticleEntity;
import co.edu.unicauca.api_conference.core.dataAccessLayer.models.ConferenceEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConferenceRepository {
    private List<ConferenceEntity> conferenceList;

    public ConferenceRepository()
    {
        conferenceList = new ArrayList<>();
        loadConferences();
    }

    public List<ConferenceEntity> findAll()
    {
        return conferenceList;
    }

    public int getArticlesCount(int id)
    {
        for(ConferenceEntity conference : conferenceList)
        {
            if(conference.getId() == id)
                return conference.getArticles().size();
        }
        return 0;
    }

    public ConferenceEntity add(ConferenceEntity conference)
    {
        if(conferenceList.add(conference))
            return conference;
        return null;
    }
    
    public boolean existsConference(int id)
    {
        for(ConferenceEntity conference : conferenceList)
        {
            if(conference.getId() == id)
                return true;
        }
        return false;
    }

    public List<ConferenceEntity> listConferencesByArticle(Integer id)
    {
        ArrayList<ConferenceEntity> conferences = new ArrayList<>();
        
        for (int i = 0; i < this.conferenceList.size(); i++)
        {
            List<ArticleEntity> articlesList = this.conferenceList.get(i).getArticles();
            for (int j = 0; j < articlesList.size(); j++)
            {
                if (articlesList.get(j).getId() == id)
                {
                    conferences.add(this.conferenceList.get(i));
                    break;
                }
            }

        }

        return conferences;
    }

    public void loadConferences()
    {
        ArrayList<ArticleEntity> articlesList1 = new ArrayList<>();
        articlesList1.add(new ArticleEntity(1));
        articlesList1.add(new ArticleEntity(2));

        ArrayList<ArticleEntity> articleList2 = new ArrayList<>();
        articleList2.add(new ArticleEntity(2));

        ArrayList<ArticleEntity> articleList3 = new ArrayList<>();
        articleList3.add(new ArticleEntity(4));
        articleList3.add(new ArticleEntity(3));
        articleList3.add(new ArticleEntity(8));

        ConferenceEntity conference1 = new ConferenceEntity(1,"Conference 1", 4, articlesList1);
        ConferenceEntity conference2 = new ConferenceEntity(2,"Conference 2", 3, articleList2);
        ConferenceEntity conference3 = new ConferenceEntity(3,"Conference 3", 2,articleList3);
        
        conferenceList.add(conference1);
        conferenceList.add(conference2);
        conferenceList.add(conference3);  

    }

}



