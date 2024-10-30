package co.edu.unicauca.rest_api.api_rest.dataAccessLayer.repositories;

import co.edu.unicauca.rest_api.api_rest.dataAccessLayer.models.ArticleEntity;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {
    private final ArrayList<ArticleEntity> articleList;
    private int pos;

    public ArticleRepository() {
        articleList = new ArrayList<>();
        loadClients();
        pos = articleList.size()+1;
    }

    public ArrayList<ArticleEntity> getAll() {
        return articleList;
    }

    public ArticleEntity getById(int id) {
        for (ArticleEntity article : articleList) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    public ArticleEntity add(ArticleEntity article) {
        article.setId(pos);
        if (articleList.add(article))
        {
            pos++;
            return article;
        }
        return null;
    }

    public ArticleEntity update(int id, ArticleEntity article) {
        for (int i = 0; i < articleList.size(); i++) {
            if (articleList.get(i).getId() == id) {
                articleList.set(i, article);
                return article;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        return articleList.removeIf(article -> article.getId() == id);
    }

    public boolean exists(int id) {
        for (ArticleEntity article : articleList) {
            if (article.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void loadClients() {
        ArticleEntity article1 = new ArticleEntity(1, "Articulo 1", "Autor 1", 1, "Revista 1");
        ArticleEntity article2 = new ArticleEntity(2, "Articulo 2", "Autor 2", 1, "Revista 2");
        ArticleEntity article3 = new ArticleEntity(3, "Articulo 3", "Autor 3", 1, "Revista 3");
        articleList.add(article1);
        articleList.add(article2);
        articleList.add(article3);
    }
}
