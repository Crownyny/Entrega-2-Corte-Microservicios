package co.edu.unicauca.rest_api.api_rest.facadeServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.rest_api.api_rest.facadeServices.DTO.ConferencesLinkArticles.ConferenceDTO;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class ConferenceService {

    @Autowired
    private WebClient.Builder webClientBuilder = WebClient.builder();

    public List<ConferenceDTO> getConferencesOfArticles(Integer idArticle) {
        String url = "http://localhost:8080/api/Conferencias/Articulos/" + idArticle;

        Mono<ConferenceDTO[]> response = webClientBuilder.build()
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(ConferenceDTO[].class);

        ConferenceDTO[] conferences = response.block();
        return conferences != null ? List.of(conferences) : List.of();
    }
}