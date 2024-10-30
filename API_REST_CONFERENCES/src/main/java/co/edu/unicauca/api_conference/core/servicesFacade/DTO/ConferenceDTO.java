package co.edu.unicauca.api_conference.core.servicesFacade.DTO;

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
