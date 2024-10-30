package co.edu.unicauca.api_conference.core.dataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceEntity {
    private int id;
    private String name;
    private int maxArticles;
    private List<ArticleEntity> articles;

    public ConferenceEntity(){}
}
