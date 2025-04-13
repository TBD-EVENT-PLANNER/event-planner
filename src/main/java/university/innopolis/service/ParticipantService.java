package university.innopolis.service;

import org.springframework.stereotype.Service;
import university.innopolis.entity.*;
import university.innopolis.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepo;
    private final ParticipantEventRepository registrationRepo;
    private final EventRepository eventRepo;

    public ParticipantService(ParticipantRepository participantRepo, ParticipantEventRepository registrationRepo, EventRepository eventRepo) {
        this.participantRepo = participantRepo;
        this.registrationRepo = registrationRepo;
        this.eventRepo = eventRepo;
    }

    public Participant registerParticipant(Participant p) {
        return participantRepo.save(p);
    }

    public void registerToEvent(Long participantId, Long eventId) {
        var participant = participantRepo.findById(participantId).orElseThrow();
        var event = eventRepo.findById(eventId).orElseThrow();
        var reg = new ParticipantEvent();
        reg.setParticipant(participant);
        reg.setEvent(event);
        registrationRepo.save(reg);
    }

    public List<Event> getParticipantEvents(Long id) {
        List<ParticipantEvent> participantEvents = registrationRepo.findByParticipantId(id);
        return participantEvents.stream()
            .map(ParticipantEvent::getEvent)
            .collect(Collectors.toList());
    }

    public void deleteRegistration(Long participantId, Long eventId) {
        registrationRepo.deleteById(new ParticipantEventId(participantId, eventId));
    }
}
