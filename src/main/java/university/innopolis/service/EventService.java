package university.innopolis.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import university.innopolis.entity.Event;
import university.innopolis.entity.Participant;
import university.innopolis.entity.ParticipantEvent;
import university.innopolis.repository.EventRepository;
import university.innopolis.repository.ParticipantEventRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final ParticipantEventRepository participantEventRepository;

    public EventService(EventRepository repo, ParticipantEventRepository participantEventRepository) {
        this.eventRepository = repo;
        this.participantEventRepository = participantEventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Participant> getParticipants(Long eventId) {
        List<ParticipantEvent> participantEvents = participantEventRepository.findByEventId(eventId);
        return participantEvents.stream()
            .map(ParticipantEvent::getParticipant)
            .collect(Collectors.toList());
    }
}
