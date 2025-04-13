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

//    public List<Event> getParticipants(Long eventId) {
//        return repo.();
//    }




    public void deleteEvent(Long id) {
        repo.deleteById(id);
    }
}
