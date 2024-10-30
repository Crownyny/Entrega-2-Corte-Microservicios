package co.edu.unicauca.api_conference.core.controllersLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import co.edu.unicauca.api_conference.core.servicesFacade.DTO.ConferenceDTO;
import co.edu.unicauca.api_conference.core.servicesFacade.services.IConferenceServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class ConferenceRestController {
    @Autowired
    private IConferenceServices conferenceServices;
    
    @GetMapping("/Conferencias")
    public List<ConferenceDTO> listarConferencias() {
        return conferenceServices.findAll();
    }

    @GetMapping("/Conferencias/existe/{id}")
    public boolean existeConferencia(@PathVariable int id) {
        return conferenceServices.existsConference(id);
    }

    @GetMapping("/Conferencias/Articulos/conteo/{id}")
    public int contarArticulos(@PathVariable int id) {
        return conferenceServices.getArticlesCount(id);
    }

    @PostMapping("/Conferencias")
    public ConferenceDTO agregarConferencia(@RequestBody ConferenceDTO conference) {
        return conferenceServices.add(conference);
    }

    @GetMapping("/Conferencias/Articulos/{id}")
    public List<ConferenceDTO> listarConferenciasPorArticulo(@PathVariable Integer id) {
        return conferenceServices.listConferencesByArticle(id);
    }
    
}
