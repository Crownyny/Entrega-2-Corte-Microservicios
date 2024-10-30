package co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.ConferencesLinkArticles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {
    private int id;
    private String name;
    private int maxArticles;

    public ConferenceDTO() {
    }
}
