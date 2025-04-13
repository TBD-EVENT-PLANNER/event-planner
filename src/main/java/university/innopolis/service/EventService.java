package university.innopolis.service;

import org.apache.commons.lang3.NotImplementedException;
import university.innopolis.entity.Event;
import university.innopolis.entity.Participant;
import university.innopolis.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository repo;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    public Event createEvent(Event event) {
        return repo.save(event);
    }

    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    public Event getEvent(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Participant> getParticipantsByEventId(Long id){
        throw new NotImplementedException();
    }

    public boolean registerParticipant(Long participantId, Long eventId){
        throw new NotImplementedException();
    }

    public void deleteEvent(Long id) {
        repo.deleteById(id);
    }
}
