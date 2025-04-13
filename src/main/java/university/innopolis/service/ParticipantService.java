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
        var participant = participantRepo.findById(participantId)
                .orElseThrow(() -> new IllegalArgumentException("Participant not found"));

        var event = eventRepo.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        long currentRegistrations = registrationRepo.countByEventId(eventId);

        if (currentRegistrations >= event.getNumberOfSeats()) {
            throw new IllegalStateException("Cannot register: event is full");
        }

        var registration = new ParticipantEvent();
        registration.setParticipant(participant);
        registration.setEvent(event);
        registrationRepo.save(registration);
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
