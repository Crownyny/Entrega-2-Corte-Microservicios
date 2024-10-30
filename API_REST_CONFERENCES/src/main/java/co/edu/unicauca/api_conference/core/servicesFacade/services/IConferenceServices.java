package co.edu.unicauca.api_conference.core.servicesFacade.services;
import java.util.List;
import co.edu.unicauca.api_conference.core.servicesFacade.DTO.ConferenceDTO;


public interface IConferenceServices {
    List<ConferenceDTO> findAll();

    ConferenceDTO add(ConferenceDTO conference);
    boolean existsConference(int id);
    int getArticlesCount(int id);
    List<ConferenceDTO> listConferencesByArticle(Integer id);
}
