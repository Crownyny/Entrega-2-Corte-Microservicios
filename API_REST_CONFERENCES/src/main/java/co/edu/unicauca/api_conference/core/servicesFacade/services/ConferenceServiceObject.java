package co.edu.unicauca.api_conference.core.servicesFacade.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import java.util.List;

import co.edu.unicauca.api_conference.core.servicesFacade.DTO.ConferenceDTO;
import co.edu.unicauca.api_conference.core.dataAccessLayer.models.ConferenceEntity;
import co.edu.unicauca.api_conference.core.dataAccessLayer.repositories.ConferenceRepository;

@Service
public class ConferenceServiceObject implements IConferenceServices{
    private  ConferenceRepository conferenceRepository;
    private ModelMapper modelMapper;

    public ConferenceServiceObject(ConferenceRepository conferenceRepository, ModelMapper modelMapper) {
        this.conferenceRepository = conferenceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ConferenceDTO> findAll() {
        List<ConferenceEntity> conferenceList = conferenceRepository.findAll();
        List<ConferenceDTO> conferencesDTO = modelMapper.map(conferenceList, 
            new TypeToken<List<ConferenceDTO>>() {}.getType());
        return conferencesDTO;
    }


    @Override
    public ConferenceDTO add(ConferenceDTO conference) {
        ConferenceEntity conferenceEntity = modelMapper.map(conference, ConferenceEntity.class);
        ConferenceEntity conferenceAdded = conferenceRepository.add(conferenceEntity);
        ConferenceDTO conferenceDTO = modelMapper.map(conferenceAdded, ConferenceDTO.class);
        return conferenceDTO;
    }

    @Override
    public boolean existsConference(int id) {
        return conferenceRepository.existsConference(id);
    }

    @Override
    public int getArticlesCount(int id) {
        return conferenceRepository.getArticlesCount(id);
    }

    @Override
    public List<ConferenceDTO> listConferencesByArticle(Integer id) {
        List<ConferenceEntity> conferenceList = conferenceRepository.listConferencesByArticle(id);
        List<ConferenceDTO> conferencesDTO = modelMapper.map(conferenceList, 
            new TypeToken<List<ConferenceDTO>>() {}.getType());
        return conferencesDTO;
    }
}
