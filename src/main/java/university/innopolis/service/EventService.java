package university.innopolis.service;

import lombok.RequiredArgsConstructor;
import university.innopolis.entity.Event;
import university.innopolis.entity.Participant;
import university.innopolis.entity.ParticipantEvent;
import university.innopolis.repository.EventRepository;
import org.springframework.stereotype.Service;
import university.innopolis.repository.ParticipantEventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final ParticipantEventRepository participantEventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event getEvent(Long id) {
        return eventRepository.getReferenceById(id);
    }

    public List<Participant> getParticipants(Long eventId) {
        List<ParticipantEvent> participantEvents = participantEventRepository.findByEventId(eventId);
        return participantEvents.stream()
                .map(ParticipantEvent::getParticipant)
                .toList();
    }
}
